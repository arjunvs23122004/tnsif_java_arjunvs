package com.tns.onlineShoping.application;

import java.util.Scanner;
import com.tns.onlineShoping.entities.*;
import com.tns.onlineShoping.services.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OnlineShoping {

    // Create service class objects
    private static ProductServices productService = new ProductServices();
    private static CustomerServices customerService = new CustomerServices();
    private static FeedbackServices feedbackService = new FeedbackServices();
    private static Ratingservice ratingservice = new Ratingservice(null);
    public static Ratingservice getRatingservice() {
		return ratingservice;
	}

	public static void setRatingservice(Ratingservice ratingservice) {
		OnlineShoping.ratingservice = ratingservice;
	}

	public static ProductServices getProductService() {
		return productService;
	}

	public static void setProductService(ProductServices productService) {
		OnlineShoping.productService = productService;
	}

	public static CustomerServices getCustomerService() {
		return customerService;
	}

	public static void setCustomerService(CustomerServices customerService) {
		OnlineShoping.customerService = customerService;
	}

	public static AdminServices getAdminService() {
		return adminService;
	}

	public static void setAdminService(AdminServices adminService) {
		OnlineShoping.adminService = adminService;
	}

	public static OrderServices getOrderService() {
		return orderService;
	}

	public static void setOrderService(OrderServices orderService) {
		OnlineShoping.orderService = orderService;
	}public static FeedbackServices getFeedbackServices() {
		return getFeedbackServices();
	}public static void setFeedbackServices(FeedbackServices feedbackServices) {
		OnlineShoping.feedbackService= feedbackService;
		}

	private static AdminServices adminService = new AdminServices();
    private static OrderServices orderService = new OrderServices();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mainChoice;

        do {
            System.out.println("\n===== Online Shopping Application =====");
            System.out.println("1. Admin Module");
            System.out.println("2. Customer Module");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    adminModule(scanner);
                    break;

                case 2:
                    customerModule(scanner);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (mainChoice != 3);
    }

    // ===================== ADMIN MODULE =====================
    private static void adminModule(Scanner scanner) {
        int adminChoice;
        do {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View Products");
            System.out.println("4. Create Admin");
            System.out.println("5. View Admins");
            System.out.println("6. Update Order Status");
            System.out.println("7. View Orders");
            System.out.println("8. Give Feedback");
            System.out.println("9. Exit Admin Module");
            System.out.print("Enter your choice: ");
            adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    removeProduct(scanner);
                    break;
                case 3:
                    viewProducts();
                    break;
                case 4:
                    createAdmin(scanner);
                    break;
                case 5:
                    viewAdmins();
                    break;
                case 6:
                    updateOrderStatus(scanner);
                    break;
                case 7:
                    viewOrders();
                    break;
                case 8:
                    viewFeedback();
                    break;
                case 9:
                    System.out.println("Exiting Admin Module...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (adminChoice != 8);
    }
    private static Map<Integer, String> feedbackItems = new LinkedHashMap<>();

    // Method to add feedback
    public void addFeedback(int customerId, String feedback) {
        feedbackItems.put(customerId, feedback);
        System.out.println("Feedback added successfully for Customer ID: " + customerId);
    }

     public static void viewFeedback() {
		// TODO Auto-generated method stub
    	 if (feedbackItems.isEmpty()) {
             System.out.println("No feedback available.");
         } else {
             System.out.println("\nCustomer Feedback List:");
             for (Map.Entry<Integer, String> entry : feedbackItems.entrySet()) {
                 System.out.println("Customer ID: " + entry.getKey() + " → " + entry.getValue());
             }
         }
	}

	// ===================== CUSTOMER MODULE =====================
    private static void customerModule(Scanner scanner) {
        int customerChoice;
        do {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. Create Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Place Order");
            System.out.println("4. View Orders");
            System.out.println("5. View Products");
            System.out.println("6. Give Feedback");
            System.out.println("7. Return to Main Menu");
            System.out.print("Enter your choice: ");
            customerChoice = scanner.nextInt();

            switch (customerChoice) {
                case 1:
                    createCustomer(scanner);
                    break;
                case 2:
                    viewCustomers();
                    break;
                case 3:
                    placeOrder(scanner);
                    break;
                case 4:
                    viewOrders();
                    break;
                case 5:
                    viewProducts();
                    break;
                case 6:
                	viewFeedback();
                    break;
                case 7:
                    System.out.println("Exiting Customer Menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (customerChoice != 6);
    }

    // ===================== ADMIN METHODS =====================
    private static void addProduct(Scanner scanner) {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter Stock Quantity: ");
        int stockQuantity = scanner.nextInt();

        Product product = new Product(productId, name, price, stockQuantity);
        productService.addProduct(product);
        System.out.println("Product added successfully!");
    }

    private static void removeProduct(Scanner scanner) {
        System.out.print("Enter Product ID to remove: ");
        int productId = scanner.nextInt();
        productService.removeProduct(productId);
        System.out.println("Product removed successfully!");
    }

    private static void createAdmin(Scanner scanner) {
        System.out.print("Enter Admin ID: ");
        int adminId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        String admin = new String(username);
        adminService.addAdmin(admin);
        System.out.println("Admin created successfully!");
    }

    private static void viewAdmins() {
        List<String> admins = adminService.getAdmins();
        if (admins.isEmpty()) {
            System.out.println("No admins found!");
        } else {
            admins.forEach(System.out::println);
        }
    }

    private static void updateOrderStatus(Scanner scanner) {
        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new status (Pending/Completed/Cancelled/Delivered): ");
        String status = scanner.nextLine();

        orderService.updateOrderStatus(orderId, status);
        System.out.println("Order status updated successfully!");
    }

    // ===================== CUSTOMER METHODS =====================
    private static void createCustomer(Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(userId, username, email, address);
        customerService.addCustomer(customer);
        System.out.println("Customer created successfully!");
    }

    private static void viewCustomers() {
        List<Customer> customers = customerService.getCustomers();
        if (customers.isEmpty()) {
            System.out.println("No customers found!");
        } else {
            customers.forEach(System.out::println);
        }
    }

    private static void placeOrder(Scanner scanner) {
        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();

        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();

        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            System.out.println("Invalid Customer ID!");
            return;
        }

        List<ProductQuantityPair> orderItems = new java.util.ArrayList<>();
        char moreItems;
        do {
            System.out.print("Enter Product ID: ");
            int productId = scanner.nextInt();
            Product product = productService.getProductById(productId);

            if (product == null) {
                System.out.println("Invalid Product ID!");
                return;
            }

            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();

            orderItems.add(new ProductQuantityPair(product, quantity));
            System.out.print("Add more items? (y/n): ");
            moreItems = scanner.next().charAt(0);
        } while (moreItems == 'y' || moreItems == 'Y');

        Order order = new Order(orderId, customer, orderItems, "Pending");
        orderService.placeOrder(order);
        System.out.println("Order placed successfully!");
    }

    private static void viewOrders() {
        List<Order> orders = orderService.getOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders found!");
        } else {
            orders.forEach(System.out::println);
        }
    }

    private static void viewProducts() {
        List<Product> products = productService.getProducts();
        if (products.isEmpty()) {
            System.out.println("No products found!");
        } else {
            products.forEach(System.out::println);
        }
    }
}