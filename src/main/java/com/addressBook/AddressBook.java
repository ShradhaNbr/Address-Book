package com.addressBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Contact> contacts = new ArrayList<>();
    static HashMap<String, ArrayList<Contact>> map = new HashMap<String, ArrayList<Contact>>();
    Contact contact = new Contact();
    static AddressBook book = new AddressBook();

    public void deleteContact() {
        System.out.println("Enter first name of contact you want to delete");
        String fName = sc.next();
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getfirstName().equalsIgnoreCase(fName)) {
                contacts.remove(i);
            } else
                System.out.println("Please enter a valid first name");
        }
        System.out.println("Contact Deleted");
        System.out.println(contacts);
    }
    public void duplicateCheck() {
        System.out.println("Enter the first name to check");
        String firstName = sc.next();
        for (int i=0;i<contacts.size();i++) {
            String contactName = contacts.get(i).getfirstName();
            if (firstName.equalsIgnoreCase(contactName)) {
                System.out.println("Contact exits");
            }else
                System.out.println("Add the contact");
                break;

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
                System.out.println("Edited List is");
                System.out.println(contacts);
            } else
                System.out.println("Please enter a valid first name");

        }
    }

    public void addContact() {
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
        System.out.println(contacts);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");
        book.addAddressBook();
    }

    public void addAddressBook() {
        while (true) {
            System.out.println("Choose your function 1. Create new address book 2. Edit details 3.Display 4. Exit");
            int choose = sc.nextInt();
            if (choose == 4) {
                System.exit(0);
                break;
            }
            switch (choose) {
                case 1:
                    System.out.println("Enter the name of Address Book");
                    String addressName = sc.next();
                    if (map.containsKey(addressName)) {
                        System.out.println("Address Book already exists");
                        break;
                    }
                    ArrayList<Contact> newAddressBook = new ArrayList<>();
                    contacts = newAddressBook;
                    while (true) {
                        System.out.println("Enter what function you want to perform");
                        System.out.println("1. Add new contact 2. Edit contact 3.Delete Contact 4.Check Duplicate");
                        int choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                book.addContact();
                                break;
                            case 2:
                                book.editContact();
                                break;
                            case 3:
                                book.deleteContact();
                                break;
                            case 4 :
                                book.duplicateCheck();
                                break;
                            default:
                                System.out.println("Please choose a valid option");
                        }
                        map.put(addressName, contacts);
                        System.out.println(map);
                        break;
                    }
                        case 2:
                            System.out.println("Enter name of address book");
                            String oldAddressBook = sc.next();
                            if (map.containsKey(oldAddressBook)) {
                                ArrayList<Contact> old_AddressBook = new ArrayList<>();
                                contacts = old_AddressBook;
                                contacts = map.get(oldAddressBook);
                                while (true) {
                                    System.out.println("Choose your function 1. Add contact 2. Edit contact 3. Delete Contact 4.To check duplicate 5.exit");
                                    int choice1 = sc.nextInt();
                                    if (choice1 == 5) {
                                        System.exit(0);
                                        break;
                                    }
                                    switch (choice1) {
                                        case 1:
                                            book.addContact();
                                            break;
                                        case 2:
                                            book.editContact();
                                            break;
                                        case 3:
                                            book.deleteContact();
                                            break;
                                        case 4:
                                            book.duplicateCheck();
                                            break;
                                        default:
                                            System.out.println("Choose a valid option");
                                    }
                                    map.put(oldAddressBook, contacts);
                                    System.out.println(map);
                                }
                            } else {
                                System.out.println("Enter valid option");
                            }
                            break;
                        case 3:
                            System.out.println(map);
                            break;
                        default:
                            System.out.println("Enter a valid option");
                    }
            }
        }
    }



