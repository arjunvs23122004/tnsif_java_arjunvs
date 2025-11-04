package com.tns.onlineShoping.services;

import java.util.ArrayList;
import java.util.List;
import com.tns.onlineShoping.entities.Order;
import com.tns.onlineShoping.entities.Product;
import com.tns.onlineShoping.entities.ProductQuantityPair;

public class OrderServices {

 private List<Order> orderList = new ArrayList<>();

 public OrderServices() {
 }

 // Place an order
 public void placeOrder(Order order) {
     orderList.add(order);
 }

 // Update order status
 public void updateOrderStatus(int orderId, String status) {
     Order order = getOrder(orderId);

     if (order == null) {
         System.out.println("Invalid Order ID!");
         return;
     }

     if ("Completed".equalsIgnoreCase(status) && "Pending".equalsIgnoreCase(order.getStatus())) {
         for (ProductQuantityPair pair : order.getProducts()) {
             Product product = pair.getProduct();
             int quantity = pair.getQuantity();

             if (product.getStockQuantity() >= quantity) {
                 product.setStockQuantity(product.getStockQuantity() - quantity);
             } else {
                 System.out.println("Insufficient stock for product: " + product.getName());
                 return;
             }
         }
     } 
     else if ("Cancelled".equalsIgnoreCase(status)) {
         if ("Completed".equalsIgnoreCase(order.getStatus()) || "Pending".equalsIgnoreCase(order.getStatus())) {
             for (ProductQuantityPair pair : order.getProducts()) {
                 Product product = pair.getProduct();
                 int quantity = pair.getQuantity();
                 product.setStockQuantity(product.getStockQuantity() + quantity);
             }
         }
     } 
     else if ("Delivered".equalsIgnoreCase(status) && "Completed".equalsIgnoreCase(order.getStatus())) {
         // Only update the status to Delivered, stock already adjusted
     } 
     else {
         System.out.println("Invalid Order Status Transition!");
         return;
     }

     order.setStatus(status);
 }

 // Retrieve Order by ID
 public Order getOrder(int orderId) {
     return orderList.stream()
             .filter(order -> order.getOrderId() == orderId)
             .findFirst()
             .orElse(null);
 }

 // Get all Orders
 public List<Order> getOrders() {
     return orderList;
 }
}