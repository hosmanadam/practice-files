package com.adamhosman;

import java.util.ArrayList;

public class UserInterface {

    public void printCustomerList(ArrayList<Customer> customers, String branchName) {
        System.out.println("\nCustomers at branch '" + branchName + "':");
        for (Customer customer : customers) {
            System.out.println("• " + customer.getName());
        }
    }

    public void printCustomerTransactions(Customer customer, String branchName) {
        System.out.println("\nTransactions at branch '" + branchName + "' for customer '" + customer.getName() +"':");
        for (Double amount : customer.getTransactions()) {
            System.out.println("• " + formatDollars(amount, true));
        }
        System.out.println("• BALANCE: " + formatDollars(customer.getBalance(), false));
    }

    public void printError() {
        printError("Something went wrong, please try again.");
    }

    public void printError(String message) {
        System.out.println("\nError: " + message);
    }

    private String formatDollars(double amount, boolean includePlusSign) {
        String plusMinus;
        if (includePlusSign) {
            plusMinus = (amount < 0 ? "-" : "+");
        } else {
            plusMinus = (amount < 0 ? "-" : "");
        }
        String absoluteValueWithDollarSign = String.format("$%,.2f", Math.abs(amount));
        return plusMinus + absoluteValueWithDollarSign;
    }

}
