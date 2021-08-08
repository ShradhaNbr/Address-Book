package com.addressBook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;

public class FileIO {
    String filePath = "C:\\Users\\HP\\java\\day19\\Address Books\\Address Book.txt";

    public void writeData(Hashtable<String, ArrayList<Contact>> personInfoDict) {
        StringBuffer empBuffer = new StringBuffer();
        personInfoDict.forEach( (companyName, personInfos) -> {
            String empDataString = companyName.concat(personInfos.toString().concat("\n"));
            empBuffer.append(empDataString);
        });

        try {
            Files.write(Paths.get(filePath) , empBuffer.toString().getBytes());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void readData() {
        try {
            Files.lines(new File(filePath).toPath())
                    .forEach(System.out::println);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}