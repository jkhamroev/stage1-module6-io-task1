package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try (FileInputStream input = new FileInputStream(file)) {
            String content = new String(input.readAllBytes());
            String[] lines = content.split(System.lineSeparator());
            String name = getValue(lines[0]);
            int age = Integer.parseInt(getValue(lines[1]));
            String email = getValue(lines[2]);
            long phone = Long.parseLong(getValue(lines[3]));
            return new Profile(name, age, email, phone);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Profile();
    }

    private String getValue(String line) {
        return line.substring(line.indexOf(' ') + 1);
    }
}
