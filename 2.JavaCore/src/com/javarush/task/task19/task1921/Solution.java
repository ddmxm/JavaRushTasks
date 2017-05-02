package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        parsing(args[0]);
    }

    public static void parsing(String file) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
            while (fileReader.ready()) {
                String str = fileReader.readLine();
                String name = str.split("\\d")[0].trim();
                Date date = dateFormat.parse(str.split(name)[1]);
                Person person = new Person(name, date);
                PEOPLE.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
