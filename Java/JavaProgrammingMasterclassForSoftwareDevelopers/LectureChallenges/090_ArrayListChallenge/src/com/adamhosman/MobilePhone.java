package com.adamhosman;

import java.util.ArrayList;

public class MobilePhone {

    private boolean isOn = false;
    private UserInterface ui = new UserInterface();
    private Contacts contacts = new Contacts();
    private ArrayList<String> menu = new ArrayList<>(){{
        add("Show contacts");
        add("Find contact");
        add("Add contact");
        add("Update contact name");
        add("Update contact number");
        add("Remove contact");
        add("Turn off");
    }};

    public MobilePhone() {
        this(false);
    }

    public MobilePhone(boolean preFillContacts) {
        if (preFillContacts) {
            contacts.addContact("Adam Hosman", "+36 (70) 123-4567");
            contacts.addContact("Kiefer Sutherland", "+1 (123) 4567-8901");
            contacts.addContact("Sting", "+1 (234) 5678-9012");
            contacts.addContact("Jerry Seinfeld", "+1 (345) 6789-0123");
        }
    }

    public void handleMenu() {
        ui.printMenu(menu);
        int choice = ui.getMenuChoice(menu);
        switch (choice) {
            case 1:
                ui.printContacts(contacts.getAll());
                break;
            case 2:
                ui.printContact(contacts.getContactByName(ui.getFullName()));
                break;
            case 3:
                ui.confirm(contacts.addContact(ui.getFullName(), ui.getPhoneNumber()));
                break;
            case 4:
                ui.confirm(contacts.updateContactName(ui.getFullName("Enter current name: "), ui.getFullName("Enter new name: ")));
                break;
            case 5:
                ui.confirm(contacts.updateContactNumber(ui.getFullName(), ui.getPhoneNumber()));
                break;
            case 6:
                ui.confirm(contacts.removeContactByName(ui.getFullName()));
                break;
            case 7:
                turnOff();
                break;
        }
    }

    public void turnOn() {
        isOn = true;
        ui.printHello();
    }

    public void turnOff() {
        ui.printGoodbye();
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

}
