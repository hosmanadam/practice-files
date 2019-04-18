package com.adamhosman;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);

    public UserInterface() {

    }

    public void confirm(Boolean success) {
        if (success) {
            System.out.println("DONE ✓");
        } else {
            System.out.println("Something went wrong, please try again.");
        }
    }

    public void printMenu(ArrayList<String> menu) {
        System.out.println("\n\n** MAIN MENU **");
        for (int i = 0; i < menu.size(); i++) {
            int optionNumber = i + 1;
            String optionDescription = menu.get(i);
            System.out.println(optionNumber + ": " + optionDescription);
        }
    }

    public void printContacts(ArrayList<Contact> contacts) {
        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }

    public void printContact(Contact contact) {
        if (contact != null) {
            System.out.println(contact.toString());
        } else {
            confirm(false);
        }
    }

    public void printHello() {
        System.out.println("\nHello!");
    }

    public void printGoodbye() {
        System.out.println("\nGoodbye!");
    }

    public int getMenuChoice(ArrayList<String> menu) {
        int choice = getInt("Please enter number of menu item: ");
        while (choice < 1 || choice > menu.size()) {
            System.out.print("Invalid choice, please try again: ");
            choice = getInt("Please enter number of menu item: ");
        }
        System.out.println("--");
        return choice;
    }

    public String getFullName() {
        return getFullName("Enter full name: ");
    }

    public String getFullName(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public String getPhoneNumber() {
        System.out.print("Enter phone number: ");
        return scanner.nextLine();
    }

    public int getInt() {
        return getInt("Please enter number: ");
    }

    public int getInt(String prompt) {
        System.out.print(prompt);
        boolean hasNextInt = scanner.hasNextInt();
        while (!hasNextInt) {
            System.out.print("Not a number, please try again: ");
            scanner.nextLine();
            hasNextInt = scanner.hasNextInt();
        }
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

}
