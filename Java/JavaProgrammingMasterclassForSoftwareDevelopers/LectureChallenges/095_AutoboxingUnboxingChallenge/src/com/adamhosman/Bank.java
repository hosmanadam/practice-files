package com.adamhosman;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches = new ArrayList<>();
    private UserInterface ui = new UserInterface();

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void createBranch(String name) {
        if (getBranchByName(name) == null) {
            Branch newBranch = new Branch(name);
            branches.add(newBranch);
            if (getBranchByName(name) == null)
                ui.printError("Can't create branch.");
        } else {
            ui.printError("Branch with name '" + name + "' already exists.");
        }
    }

    private Branch getBranchByName(String name) {
        for (Branch branch : branches) {
            if (branch.getName().equals(name))
                return branch;
        }
        return null;
    }

    public void addTransaction(String branchName, String customerName, double amount) {
        Branch branch = getBranchByName(branchName);
        if (branch != null) {
            int returnCode = branch.addTransaction(customerName, amount);
            if (returnCode == -1)
                ui.printError("Can't add transaction, customer '" + customerName + "' not on file at branch '" + branchName + "'.");
            if (returnCode == -2)
                ui.printError("System failure, can't add transaction.");
        } else {
            ui.printError("No branch with name '" + branchName + "'.");
        }
    }

    public void addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branch = getBranchByName(branchName);
        if (branch != null)
            if (!branch.addCustomer(customerName, initialTransaction))
                ui.printError("Customer '" + customerName + "' already on file at branch '" + branchName + "'.");
    }

    public void printCustomerList(String branchName) {
        Branch branch = getBranchByName(branchName);
        if (branch != null) {
            ArrayList<Customer> customers = branch.getCustomers();
            if (customers != null) {
                ui.printCustomerList(customers, branchName);
            } else {
                ui.printError("Customers not found.");
            }

        } else {
            ui.printError("Branch not found.");
        }
    }

    public void printTransactionsOfCustomer(String branchName, String customerName) {
        Branch branch = getBranchByName(branchName);
        if (branch != null) {
            Customer customer = branch.getCustomerByName(customerName);
            if (customer != null) {
                ui.printCustomerTransactions(customer, branchName);
            } else {
                ui.printError("Customer not found.");
            }

        } else {
            ui.printError("Branch not found.");
        }
    }

}
