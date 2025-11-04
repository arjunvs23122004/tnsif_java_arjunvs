package com.tns.onlineShoping.entities;
import java.util.*;
public class Rating {
	    private String name;
	    private List<Integer> ratings;

	    public Rating(String name) {
	        this.name = name;
	        this.ratings = new ArrayList<>();
	    }

	    public String getName() {
	        return name;
	    }

	    public void addRating(int rating) {
	        if (rating >= 1 && rating <= 5) {
	            ratings.add(rating);
	            System.out.println("Rating added successfully!");
	        } else {
	            System.out.println("Invalid rating! Please enter a number between 1 and 5.");
	        }
	    }

	    public double getAverageRating() {
	        if (ratings.isEmpty()) {
	            return 0.0;
	        }
	        double sum = 0;
	        for (int r : ratings) {
	            sum += r;
	        }
	        return sum / ratings.size();
	    }

	    public void showDetails() {
	        System.out.println("\nProduct: " + name);
	        System.out.println("Total Ratings: " + ratings.size());
	        System.out.printf("Average Rating: %.2f ⭐\n", getAverageRating());
	    }
	}

 class ProductRatingsystem{
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        Map<Integer, Rating> products = new HashMap<>();

	        // Add some products
	        products.put(1, new Rating("Laptop"));
	        products.put(2, new Rating("Smartphone"));
	        products.put(3, new Rating("Headphones"));
	        products.put(3, new Rating(""));
	        products.put(3, new Rating("Headphones"));

	        while (true) {
	            System.out.println("\n===== PRODUCT RATING SYSTEM =====");
	            System.out.println("1. Rate a Product");
	            System.out.println("2. View Product Ratings");
	            System.out.println("3. Exit");
	            System.out.print("Choose an option: ");
	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.println("\nAvailable Products:");
	                    for (Map.Entry<Integer, Rating> entry : products.entrySet()) {
	                        System.out.println(entry.getKey() + ". " + entry.getValue().getName());
	                    }
	                    System.out.print("Enter product number: ");
	                    int productChoice = sc.nextInt();
	                    Rating selected = products.get(productChoice);

	                    if (selected != null) {
	                        System.out.print("Enter rating (1–5): ");
	                        int rating = sc.nextInt();
	                        selected.addRating(rating);
	                    } else {
	                        System.out.println(" Invalid product selection!");
	                    }
	                    break;

	                case 2:
	                    System.out.println("\n===== PRODUCT RATINGS =====");
	                    for (Rating p : products.values()) {
	                        p.showDetails();
	                    }
	                    break;

	                case 3:
	                    System.out.println("Thank you for using the Product Rating System!");
	                    sc.close();
	                    return;

	                default:
	                    System.out.println(" Invalid choice! Try again.");
	            }
	        }
	    }
	}

