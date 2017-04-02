package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        TreeSet<String> allNames = new TreeSet();
        String filename = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!(filename = reader.readLine()).equals("end") || filename.isEmpty()) {
                allNames.add(filename);
            }

            filename = allNames.first().substring(0, allNames.first().lastIndexOf(".part"));

            try (BufferedOutputStream fileWriter = new BufferedOutputStream(new FileOutputStream(filename))) {
                for (String s : allNames) {
                    try (BufferedInputStream fileReader = new BufferedInputStream(new FileInputStream(s))) {
                        while (fileReader.available() > 0) {
                            fileWriter.write(fileReader.read());
                            fileWriter.flush();
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
