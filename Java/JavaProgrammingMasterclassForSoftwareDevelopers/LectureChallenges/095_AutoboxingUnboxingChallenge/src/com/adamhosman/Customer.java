package com.adamhosman;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double amount) {
        transactions.add(amount);
    }

    public int getTransactionCount() {
        return transactions.size();
    }

    public double getBalance() {
        double balance = 0.0;
        for (Double amount : transactions) {
            balance += amount;
        }
        return balance;
    }

}
