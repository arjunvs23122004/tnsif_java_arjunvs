package com.tns.onlineShoping.services;
import java.util.ArrayList;
import java.util.List;
import com.tns.onlineShoping.entities.Product;

public class ProductServices {

 private List<Product> productList = new ArrayList<>();

 public void addProduct(Product product) {
     productList.add(product);
 }

 public void removeProduct(int productId) {
     productList.removeIf(product -> product.getProductId() == productId);
 }

 public List<Product> getProducts() {
     return productList;
 }

 public Product getProductById(int productId) {
     return productList.stream()
             .filter(product -> product.getProductId() == productId)
             .findFirst()
             .orElse(null);
 }
}
