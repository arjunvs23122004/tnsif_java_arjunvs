package com.tns.onlineShoping.entities;

import java.util.ArrayList;
import java.util.List;

public class ShopingCart {
	  	private int cartId;
	    private Customer customer;
	    private List<ProductQuantityPair> items;

	    public void ShoppingCart(int cartId, Customer customer) {
	        this.cartId = cartId;
	        this.customer = customer;
	        this.items = new ArrayList<>();
	    }

	   

	    public int getCartId() {
			return cartId;
		}



		public void setCartId(int cartId) {
			this.cartId = cartId;
		}



		public Customer getCustomer() {
			return customer;
		}



		public void setCustomer(Customer customer) {
			this.customer = customer;
		}



		public List<ProductQuantityPair> getItems() {
			return items;
		}



		public void setItems(List<ProductQuantityPair> items) {
			this.items = items;
		}



		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return ("ShoppingCart [cartId=" + cartId + ", customer=" + customer.getName() +
		               ", totalItems=" + items.size() + ", totalPrice=]");
		}



		
}
