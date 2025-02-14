import inventory.models.*;
import inventory.app.*;

import java.util.Date;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();
        manager.loadInventory("inventory.dat");

        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Product to Inventory");
            System.out.println("2. View Inventory");
            System.out.println("3. Update Product Attributes");
            System.out.println("4. Buy Product");
            System.out.println("5. Sell Product");
            System.out.println("6. Remove Product from Inventory");
            System.out.println("7. View Transaction History");
            System.out.println("8. Save Inventory and Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter Supplier: ");
                    String supplier = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter Reorder Level: ");
                    int reorderLevel = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter Expiration Date (yyyy-MM-dd): ");
                    String expirationDateStr = scanner.nextLine();
                    Date expirationDate = manager.parseDate(expirationDateStr);
                    manager.addProduct(new Product(id, name, category, supplier, price, quantity, reorderLevel, expirationDate));
                    break;
                case 2:
                    manager.viewInventory();
                    break;
                case 3:
                    System.out.print("Enter Product ID to update: ");
                    String updateId = scanner.nextLine();
                    manager.updateProductAttributes(updateId, scanner);
                    break;
                case 4:
                    System.out.print("Enter Product ID to buy: ");
                    String buyId = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int buyQuantity = scanner.nextInt();
                    manager.buyProduct(buyId, buyQuantity);
                    break;
                case 5:
                    System.out.print("Enter Product ID to sell: ");
                    String sellId = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int sellQuantity = scanner.nextInt();
                    manager.sellProduct(sellId, sellQuantity);
                    break;
                case 6:
                    System.out.print("Enter Product ID to remove: ");
                    String removeId = scanner.nextLine();
                    manager.removeProduct(removeId);
                    break;
                case 7:
                    manager.viewTransactionHistory();
                    break;
                case 8:
                    manager.saveInventory("inventory.dat");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}