package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            Map<String, Double> people = new TreeMap<>();
            while (fileReader.ready()) {
                String[] str = fileReader.readLine().trim().split(" ");
                String name = str[0];
                Double eq = Double.valueOf(str[1]);
                people.put(name, (people.containsKey(name) ? people.get(name) + eq : eq));
            }

            for (Map.Entry entry : people.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
