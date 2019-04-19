package com.adamhosman;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Branch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean addCustomer(String name, double initialDeposit) {
        if (getCustomerByName(name) == null) {
            Customer newCustomer = new Customer(name);
            newCustomer.addTransaction(initialDeposit);
            customers.add(newCustomer);
            return (getCustomerByName(name) != null);
        }
        return false;
    }

    public int addTransaction(String customerName, double amount) {
        Customer customer = getCustomerByName(customerName);
        if (customer != null) {
            int initialTransactionCount = customer.getTransactionCount();
            customer.addTransaction(amount);
            if (customer.getTransactionCount() == initialTransactionCount + 1) {
                return 1;
            } else {
                return -2;
            }
        }
        return -1;
    }

    public Customer getCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name))
                return customer;
        }
        return null;
    }

}
