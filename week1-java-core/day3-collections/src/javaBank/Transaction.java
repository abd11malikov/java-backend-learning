package javaBank;

import java.time.LocalDateTime;


public class Transaction {
    private String type; // Deposit Withdraw
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(String type, double amount){
        this.type=type;
        this.amount = amount;
        timestamp= LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + type + ": $" + amount;
    }

}
