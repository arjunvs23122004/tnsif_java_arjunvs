package com.tns.onlineShoping.services;
import java.util.ArrayList;
import java.util.List;
import com.tns.onlineShoping.entities.Customer;
public class CustomerServices {
	private List<Customer> customerList = new ArrayList<>();

    public void addCustomer(Customer customer) { customerList.add(customer); }

    public Customer getCustomer(int userId) {
        return customerList.stream()
                .filter(c -> c.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

    public List<Customer> getCustomers() { return customerList;
    }
}
