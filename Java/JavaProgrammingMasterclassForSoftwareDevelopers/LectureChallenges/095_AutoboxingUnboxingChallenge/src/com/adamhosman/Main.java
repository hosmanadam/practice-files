package com.adamhosman;

/**
 * https://www.udemy.com/java-the-complete-java-developer-course/learn/lecture/3323798
 *
 * You job is to create a simple banking application.
 * There should be a Bank class ✓
 * It should have an arraylist of Branches ✓
 * Each Branch should have an arraylist of Customers ✓
 * The Customer class should have an arraylist of Doubles (transactions) ✓
 * Customer:
 * Name, and the ArrayList of doubles. ✓
 * Branch:
 * Need to be able to add a new customer and initial transaction amount. ✓
 * Also needs to add additional transactions for that customer/branch ✓
 * Bank:
 * Add a new branch ✓
 * Add a customer to that branch with initial transaction ✓
 * Add a transaction for an existing customer for that branch ✓
 * Show a list of customers for a particular branch and optionally a list
 * of their transactions ✓
 * Demonstration autoboxing and unboxing in your code ✓
 * Hint: Transactions
 * Add data validation.
 * e.g. check if exists, or does not exist, etc. ✓
 * Think about where you are adding the code to perform certain actions
 */
public class Main {

    public static void main(String[] args) {
    	Bank bank = new Bank("CashExpress");
    	bank.createBranch("HQ");
    	bank.createBranch("HQ");  // Should print error (duplicate branch name)

    	bank.addCustomer("HQ", "Bill Gates", 10_000_000.0);
    	bank.addCustomer("HQ", "Bill Gates", 10_000_000.0);  // Should print error (duplicate customer name)
    	bank.addCustomer("HQ", "Barack Obama", 10_000.0);
    	bank.addCustomer("HQ", "Michael Jackson", 30_000_000.0);

    	bank.addTransaction("HQ", "Barack Obama", 15_000.0);
    	bank.addTransaction("HQ", "Barack Obama", 15_000.0);
    	bank.addTransaction("HQ", "Barack Obama", 5_000.0);
    	bank.addTransaction("H", "Barack Obama", 5_000.0);  // Should print error (mistyped branch name)
    	bank.addTransaction("HQ", "Barack Obama", 10_000.0);
    	bank.addTransaction("HQ", "Barack Obam", 10_000.0);  // Should print error (mistyped customer name)
    	bank.addTransaction("HQ", "Barack Obama", -5_555.0);
    	bank.addTransaction("HQ", "Barack Obama", 2_000.0);
    	bank.addTransaction("HQ", "Barack Obama", 8_000.0);
    	bank.addTransaction("HQ", "Barack Obama", -20_000.0);

        bank.printCustomerList("HQ");
        bank.printTransactionsOfCustomer("HQ", "Barack Obama");
    }
}
