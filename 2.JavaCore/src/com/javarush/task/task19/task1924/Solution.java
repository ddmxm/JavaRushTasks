package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {

    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            digitToString(consoleReader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void digitToString(String file) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            StringBuffer fullStr = new StringBuffer("");
            while (fileReader.ready()) {
                String[] str = fileReader.readLine().split(" ");
                for (int i = 0; i < str.length; i++) {
                    if (str[i].matches("^\\d+$")) {
                        if (map.containsKey(Integer.valueOf(str[i]))) {
                            if (i == str.length - 1) {
                                fullStr.append(map.get(Integer.valueOf(str[i])) + "\n");
                            } else {
                                fullStr.append(map.get(Integer.valueOf(str[i])) + " ");
                            }
                        } else fullStr.append(str[i] + " ");
                    } else {
                        fullStr.append(str[i] + " ");
                    }
                }
            }
            System.out.println(fullStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
