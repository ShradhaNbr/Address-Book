package com.addressBook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Contact> contacts = new ArrayList<>();

       public void deleteContact() {
        System.out.println("Enter first name of contact you want to delete");
        String fName = sc.next();
        for (int i=0;i<contacts.size();i++) {
            if (contacts.get(i).getfirstName().equalsIgnoreCase(fName)) {
                contacts.remove(i);
            }
            else
                System.out.println("Please enter a valid first name");
        }
    }

    public void editContact() {
        System.out.println("Enter the first name of contact you want to edit");
        String fName = sc.next();
        for (Contact contact : contacts) {
            if (contact.getfirstName().equalsIgnoreCase(fName)) {
                System.out.println("Select what you want to edit 1. First Name 2. Last Name 3. Address 4.city 5. State 6.zip code 7.Phone number 8.Email id");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter new first Name");
                        contact.setfirstName(sc.next());
                    }
                    case 2 -> {
                        System.out.println("Enter new last Name");
                        contact.setlastName(sc.next());
                    }
                    case 3 -> {
                        System.out.println("Enter new Address");
                        contact.setaddress(sc.next());
                    }
                    case 4 -> {
                        System.out.println("Enter new city");
                        contact.setcity(sc.next());
                    }
                    case 5 -> {
                        System.out.println("Enter new state");
                        contact.setstate(sc.next());
                    }
                    case 6 -> {
                        System.out.println("Enter new zip code");
                        contact.setzip(sc.nextLong());
                    }
                    case 7 -> {
                        System.out.println("Enter new phone number");
                        contact.setphoneNumber(sc.nextLong());
                    }
                    case 8 -> {
                        System.out.println("Enter new email");
                        contact.setemail(sc.next());
                    }
                    default -> System.out.println("Invalid Choice");
                }

            } else
                System.out.println("Please enter a valid first name");
        }
    }

    public void addContact() {
        Contact contact = new Contact();
        System.out.println("Enter the first name");
        contact.setfirstName(sc.next());
        System.out.println("Enter the last name");
        contact.setlastName(sc.next());
        System.out.println("Enter the Address");
        contact.setaddress(sc.next());
        System.out.println("Enter the city");
        contact.setcity(sc.next());
        System.out.println("Enter the State");
        contact.setstate(sc.next());
        System.out.println("Enter the zip code");
        contact.setzip(sc.nextLong());
        System.out.println("Enter the phone number");
        contact.setphoneNumber(sc.nextLong());
        System.out.println("Enter the Email Id");
        contact.setemail(sc.next());
        contacts.add(contact);
    }

    public static void main(String[] args) {
        AddressBook book = new AddressBook();
        System.out.println("Welcome to Address Book");
        System.out.println("Enter what function you want to perform");
        System.out.println("1. add new contact 2. Edit contact 3.Delete Contact");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> book.addContact();
            case 2 -> book.editContact();
            case 3 -> book.deleteContact();
        }
    }
}
