package models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product implements Serializable {
    private String productId;
    private String name;
    private String category;
    private String supplier;
    private double price;
    private int quantity;
    private int reorderLevel;
    private Date expirationDate;

    public Product(String productId, String name, String category, String supplier, double price, int quantity, int reorderLevel, Date expirationDate) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.supplier = supplier;
        this.price = price;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
        this.expirationDate = expirationDate;
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getSupplier() { return supplier; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public int getReorderLevel() { return reorderLevel; }
    public Date getExpirationDate() { return expirationDate; }

    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setSupplier(String supplier) { this.supplier = supplier; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setReorderLevel(int reorderLevel) { this.reorderLevel = reorderLevel; }
    public void setExpirationDate(Date expirationDate) { this.expirationDate = expirationDate; }

    public void displayProduct() {
        System.out.printf("%-10s %-15s %-15s %-15s %-10.2f %-10d %-10d %-15s%n",
                productId, name, category, supplier, price, quantity, reorderLevel,
                new SimpleDateFormat("yyyy-MM-dd").format(expirationDate));
    }

    private static final long serialVersionUID = 1L;
}
