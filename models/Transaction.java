package inventory.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction implements Serializable {
    private static int transactionCount = 0;
    private final int transactionId;
    private String productId;
    private String action;
    private int quantity;
    private Date date;

    public Transaction(String productId, String action, int quantity) {
        this.transactionId = ++transactionCount;
        this.productId = productId;
        this.action = action;
        this.quantity = quantity;
        this.date = new Date();
    }

    public void displayTransaction() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        System.out.printf("Transaction ID: %d, Product ID: %s, Action: %s, Quantity: %d, Date: %s%n",
                transactionId, productId, action, quantity, formatter.format(date));
    }

    private static final long serialVersionUID = 1L;
}
