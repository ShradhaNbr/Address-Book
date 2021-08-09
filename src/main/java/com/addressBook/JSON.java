package com.addressBook;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import com.google.gson.Gson;

public class JSON {
    public static void writeDataToJSon() throws IOException {
        {
            Path filePath = Paths.get("C:\\Users\\HP\\java\\day19\\Address Books\\Address Book.json");
            Gson gson = new Gson();
            String json = gson.toJson(AddressBookMain.contactList);
            FileWriter writer = new FileWriter(String.valueOf(filePath));
            writer.write(json);
            writer.close();
        }
    }

    // Read from JSON
    public static void readDataFromJson() throws IOException {
        ArrayList<Contact> contactList;
        Path filePath = Paths.get("C:\\Users\\HP\\java\\day19\\Address Books\\Address Book.json");
        try (Reader reader = Files.newBufferedReader(filePath)) {
            Gson gson = new Gson();
            contactList = new ArrayList<>(Arrays.asList(gson.fromJson(reader, Contact[].class)));
            for (Contact contact : contactList) {
                System.out.println("Firstname : " + contact.getFirstName());
                System.out.println("Lastname : " + contact.getLastName());
                System.out.println("Address : " + contact.getAddress());
                System.out.println("City : " + contact.getCity());
                System.out.println("State : " + contact.getState());
                System.out.println("Zip Code : " + contact.getZipCode());
                System.out.println("Phone number : " + contact.getPhoneNumber());
                System.out.println("Email : " + contact.getEmail());
            }
        }
    }
}