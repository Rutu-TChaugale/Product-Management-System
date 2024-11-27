package com.rutu.client;

import com.rutu.controller.ProductMangement;
import com.rutu.model.Product;

import java.util.Scanner;

public class ProductManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductMangement controller = new ProductMangement(10);

        while (true) {
            System.out.println("\n--- Product Management System ---");
            System.out.println("1. Add New Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Find Product by Name");
            System.out.println("4. Filter Products (Price < 500)");
            System.out.println("5. Filter Products (Price > 1000)");
            System.out.println("6. Find Product by Type");
            System.out.println("7. Find Product by ID");
            System.out.println("8. Filter Products (Quantity < 2)");
            System.out.println("9. Update Product");
            System.out.println("10. Delete Product");
            System.out.println("11. Search Products by Price Range");
            System.out.println("12. Sort Products by Price");
            System.out.println("13. Total Number of Products");
            System.out.println("14. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Product Type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter Product Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Product Quantity: ");
                    int qty = scanner.nextInt();
                    Product product = new Product(id, name, type, price, qty);
                    if (controller.addProduct(product)) {
                        System.out.println("Product added successfully.");
                    } else {
                        System.out.println("Failed to add product.");
                    }
                }
                case 2 -> {
                    Product[] products = controller.getAllProducts();
                    for (Product product : products) {
                        System.out.println(product);
                    }
                }
                case 3 -> {
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    Product[] products = controller.findProductsByName(name);
                    for (Product product : products) {
                        System.out.println(product);
                    }
                }
                case 4 -> {
                    Product[] products = controller.filterProductsByPrice(500, true);
                    for (Product product : products) {
                        System.out.println(product);
                    }
                }
                case 5 -> {
                    Product[] products = controller.filterProductsByPrice(1000, false);
                    for (Product product : products) {
                        System.out.println(product);
                    }
                }
                case 6 -> {
                    System.out.print("Enter Product Type: ");
                    String type = scanner.nextLine();
                    Product[] products = controller.findProductsByType(type);
                    for (Product product : products) {
                        System.out.println(product);
                    }
                }
                case 7 -> {
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    Product product = controller.findProductById(id);
                    System.out.println(product != null ? product : "Product not found.");
                }
                case 8 -> {
                    Product[] products = controller.filterProductsByQty(2);
                    for (Product product : products) {
                        System.out.println(product);
                    }
                }
                case 9 -> {
                    System.out.print("Enter Product ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter New Product Type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter New Product Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter New Product Quantity: ");
                    int qty = scanner.nextInt();
                    Product updatedProduct = new Product(id, name, type, price, qty);
                    if (controller.updateProduct(id, updatedProduct)) {
                        System.out.println("Product updated successfully.");
                    } else {
                        System.out.println("Product not found.");
                    }
                }
                case 10 -> {
                    System.out.print("Enter Product ID to delete: ");
                    int id = scanner.nextInt();
                    if (controller.deleteProduct(id)) {
                        System.out.println("Product deleted successfully.");
                    } else {
                        System.out.println("Product not found.");
                    }
                }
                case 11 -> {
                    System.out.print("Enter Min Price: ");
                    double minPrice = scanner.nextDouble();
                    System.out.print("Enter Max Price: ");
                    double maxPrice = scanner.nextDouble();
                    Product[] products = controller.searchProductsByPriceRange(minPrice, maxPrice);
                    for (Product product : products) {
                        System.out.println(product);
                    }
                }
                case 12 -> {
                    System.out.print("Enter 1 for Ascending, 0 for Descending: ");
                    boolean ascending = scanner.nextInt() == 1;
                    Product[] products = controller.sortProductsByPrice(ascending);
                    for (Product product : products) {
                        System.out.println(product);
                    }
                }
                case 13 -> {
                    System.out.println("Total number of products: " + controller.getProductCount());
                }
                case 14 -> {
                    System.out.println("Exiting the system...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
