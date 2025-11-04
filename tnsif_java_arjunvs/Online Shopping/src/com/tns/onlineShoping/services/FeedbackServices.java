package com.tns.onlineShoping.services;

import java.util.LinkedHashMap;
import java.util.Map;

public class FeedbackServices {

    // Map to store feedbacks (CustomerID → Feedback Message)
    private Map<Integer, String> feedbackList = new LinkedHashMap<>();

    // Method to add feedback
    public void addFeedback(int customerId, String feedback) {
        feedbackList.put(customerId, feedback);
        System.out.println("Feedback added successfully for Customer ID: " + customerId);
    }

    // Method to view all feedback
    public void viewFeedback() {
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback available.");
        } else {
            System.out.println("\nCustomer Feedback List:");
            for (Map.Entry<Integer, String> entry : feedbackList.entrySet()) {
                System.out.println("Customer ID: " + entry.getKey() + " → " + entry.getValue());
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        FeedbackServices service = new FeedbackServices();

        service.addFeedback(101, "Great product!");
        service.addFeedback(102, "Fast delivery!");
        service.viewFeedback();
    }
}
