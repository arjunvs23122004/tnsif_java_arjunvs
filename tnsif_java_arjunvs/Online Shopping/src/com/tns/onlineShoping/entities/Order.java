package com.tns.onlineShoping.entities;
import java.util.List;
public class Order {
	 private int orderId;
	    private Customer customer;
	    private List<ProductQuantityPair> products;
	    private String status;
		public Order(int orderId2, Customer customer2, List<ProductQuantityPair> orderItems, String string) {
			// TODO Auto-generated constructor stub
		}
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		public List<ProductQuantityPair> getProducts() {
			return products;
		}
		public void setProducts(List<ProductQuantityPair> products) {
			this.products = products;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return("Order [orderId=" + orderId + ", customer=" + customer.getName() +", status=" + status + ", products=" + products+"]");
		}

	    
}
