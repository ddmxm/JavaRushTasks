package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileReader = new FileInputStream(consoleReader.readLine())
        ) {
            load(fileReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties propertie = new Properties();
        for (Map.Entry i : properties.entrySet()) {
            propertie.setProperty(i.getKey().toString(), i.getValue().toString());
        }
        propertie.store(outputStream, "Properties сохранены!");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties propertie = new Properties();
        propertie.load(inputStream);
        properties.clear();
        for (Map.Entry i : propertie.entrySet()) {
            properties.put(i.getKey().toString(), i.getValue().toString());
        }
        inputStream.close();
    }

    public static void main(String[] args) {

    }
}
