package app;

import models.Product;
import models.Transaction;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("unchecked")
public class InventoryManager {
    private Map<String, Product> inventory = new HashMap<>();
    private List<Transaction> transactions = new ArrayList<>();
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

    public void loadInventory(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Object> data = (List<Object>) ois.readObject();
            inventory = (Map<String, Product>) data.get(0);
            transactions = (List<Transaction>) data.get(1);
            System.out.println("Inventory and transactions loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous data found. Starting fresh.");
        }
    }

    public void saveInventory(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            List<Object> data = new ArrayList<>();
            data.add(inventory);
            data.add(transactions);
            oos.writeObject(data);
            System.out.println("Inventory and transactions saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving inventory data.");
        }
    }

    public void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.printf("%-10s %-15s %-15s %-15s %-10s %-10s %-10s %-15s%n",
                    "ID", "Name", "Category", "Supplier", "Price", "Quantity", "Reorder", "Expiry Date");
            double finalTotalPrice = 0; // To calculate the total price of all products
            for (Product product : inventory.values()) {
                product.displayProduct();
                finalTotalPrice += product.getPrice() * product.getQuantity(); // Accumulate total price
            }
            System.out.printf("%nFinal Total Price of All Products: %.2f%n", finalTotalPrice);
        }
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        transactions.add(new Transaction(product.getProductId(), "Add", product.getQuantity()));
        System.out.println("Product added successfully.");
    }

    public void updateProductAttributes(String productId, Scanner scanner) {
        Product product = inventory.get(productId);
        if (product != null) {
            System.out.println("Enter new values or press Enter to keep current values.");
            System.out.print("Name (" + product.getName() + "): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) product.setName(newName);

            System.out.print("Category (" + product.getCategory() + "): ");
            String newCategory = scanner.nextLine();
            if (!newCategory.isEmpty()) product.setCategory(newCategory);

            System.out.print("Supplier (" + product.getSupplier() + "): ");
            String newSupplier = scanner.nextLine();
            if (!newSupplier.isEmpty()) product.setSupplier(newSupplier);

            System.out.print("Price (" + product.getPrice() + "): ");
            String newPrice = scanner.nextLine();
            if (!newPrice.isEmpty()) product.setPrice(Double.parseDouble(newPrice));

            System.out.print("Quantity (" + product.getQuantity() + "): ");
            String newQuantity = scanner.nextLine();
            if (!newQuantity.isEmpty()) product.setQuantity(Integer.parseInt(newQuantity));

            System.out.print("Reorder Level (" + product.getReorderLevel() + "): ");
            String newReorderLevel = scanner.nextLine();
            if (!newReorderLevel.isEmpty()) product.setReorderLevel(Integer.parseInt(newReorderLevel));

            System.out.print("Expiration Date (" + dateFormatter.format(product.getExpirationDate()) + "): ");
            String newExpirationDate = scanner.nextLine();
            if (!newExpirationDate.isEmpty()) product.setExpirationDate(parseDate(newExpirationDate));

            System.out.println("Product attributes updated successfully.");
            transactions.add(new Transaction(productId, "Update", 0));
        } else {
            System.out.println("Product not found.");
        }
    }

    public void buyProduct(String productId, int quantity) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(product.getQuantity() + quantity);
            transactions.add(new Transaction(productId, "Buy", quantity));
            System.out.println("Purchase recorded successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void sellProduct(String productId, int quantity) {
        Product product = inventory.get(productId);
        if (product != null) {
            if (product.getQuantity() >= quantity) {
                product.setQuantity(product.getQuantity() - quantity);
                transactions.add(new Transaction(productId, "Sell", quantity));
                System.out.println("Sale recorded successfully.");
            } else {
                System.out.println("Insufficient stock to sell.");
            }
        } else {
            System.out.println("Product not found.");
        }
    }

    public void removeProduct(String productId) {
        Product product = inventory.remove(productId);
        if (product != null) {
            transactions.add(new Transaction(productId, "Remove", product.getQuantity()));
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void viewTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions recorded.");
        } else {
            System.out.println("Transaction History:");
            for (Transaction transaction : transactions) {
                transaction.displayTransaction();
            }
        }
    }

    public Date parseDate(String dateString) {
        try {
            return dateFormatter.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return null;
        }
    }
}
