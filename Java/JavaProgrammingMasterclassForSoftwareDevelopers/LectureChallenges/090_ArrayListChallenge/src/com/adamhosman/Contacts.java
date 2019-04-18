package com.adamhosman;

import java.util.ArrayList;

public class Contacts {

    private ArrayList<Contact> contacts;

    public Contacts() {
        contacts = new ArrayList<>();
    }

    public ArrayList<Contact> getAll() {
        return contacts;
    }

    public Contact getContactByName(String fullName) {
        for (Contact contact : contacts) {
            if (contact.getFullName().equals(fullName)) {
                return contact;
            }
        }
        return null;
    }

    public boolean addContact(String fullName, String phoneNumber) {
        contacts.add(new Contact(fullName, phoneNumber));
        return (getContactByName(fullName) != null);
    }

    public boolean updateContactName(String oldName, String newName) {
        Contact contact = getContactByName(oldName);
        if (contact != null) {
            contact.setFullName(newName);
            return true;
        }
        return false;
    }

    public boolean updateContactNumber(String fullName, String newNumber) {
        Contact contact = getContactByName(fullName);
        if (contact != null) {
            contact.setPhoneNumber(newNumber);
            return true;
        }
        return false;
    }

    public boolean removeContactByName(String fullName) {
        boolean found = false;
        int indexToRemove = 0;
        for (Contact contact : contacts) {
            if (contact.getFullName().equals(fullName)) {
                indexToRemove = contacts.indexOf(contact);
                found = true;
                break;
            }
        }
        if (found) {
            contacts.remove(indexToRemove);
        }
        return found;
    }

}
