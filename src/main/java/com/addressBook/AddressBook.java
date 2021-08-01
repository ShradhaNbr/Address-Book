package com.addressBook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Contact> contacts = new ArrayList<>();
    public static void main(String[] args) {
        AddressBook book = new AddressBook();
        System.out.println("Welcome to Address Book");
        System.out.println("Enter what function you want to perform");
        System.out.println("1. add new contact 2. Edit contact");
        int choice = sc.nextInt();
                switch(choice) {
                    case 1 : book.addContact();
                    break;
                    case 2: book.editContact();
                    break;
                }
    }

    public void editContact() {
        System.out.println("Enter the first name of contact you want to edit");
        String fName = sc.next();
        for (int i=0;i< contacts.size();i++) {
            if(contacts.get(i).getfirstName().equalsIgnoreCase(fName)) {
                System.out.println("Select what you want to edit 1. First Name 2. Last Name 3. Address 4.city 5. State 6.zip code 7.Phone number 8.Email id");
                int choice = sc.nextInt();
                    switch (choice) {
                        case 1 : System.out.println("Enter new first Name");
                        contacts.get(i).setfirstName(sc.next());
                        break;
                        case 2 : System.out.println("Enter new last Name");
                            contacts.get(i).setlastName(sc.next());
                            break;
                        case 3 : System.out.println("Enter new Address");
                            contacts.get(i).setaddress(sc.next());
                            break;
                        case 4 : System.out.println("Enter new city");
                            contacts.get(i).setcity(sc.next());
                            break;
                        case 5 : System.out.println("Enter new state");
                            contacts.get(i).setstate(sc.next());
                            break;
                        case 6 : System.out.println("Enter new zip code");
                            contacts.get(i).setzip(sc.nextLong());
                            break;
                        case 7 : System.out.println("Enter new phone number");
                            contacts.get(i).setphoneNumber(sc.nextLong());
                            break;
                        case 8 : System.out.println("Enter new email");
                            contacts.get(i).setemail(sc.next());
                            break;
                        default:
                            System.out.println("Invalid Choice");
                    }

            }
            else
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
    }
}
