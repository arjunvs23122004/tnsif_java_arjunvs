package com.tns.onlineShoping.entities;

public class Customer {
	
	    private int userId;
	    private String name;
	    private String email;

	    public Customer(int userId, String name, String email) {
	        this.userId = userId;
	        this.name = name;
	        this.email = email;
	    }

	    public Customer(int userId2, String username, String email2, String address) {
			// TODO Auto-generated constructor stub
		}

		public int getUserId() { return userId; }
	    public void setUserId(int userId) { this.userId = userId; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return ("Customer [userId=" + userId + ", name=" + name + ", email=" + email+"]");
		}

	    
	}

