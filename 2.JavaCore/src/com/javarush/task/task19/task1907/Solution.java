package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader = new FileReader(consoleReader.readLine());
        ){
            //Map<String, Integer> map = new HashMap<>();
            String string = null;

            while (fileReader.ready()) {
                string += String.valueOf((char) fileReader.read());
            }

            String[] strings = string.split("\\W");
            int eq = 0;

            for (String i : strings) {
                if (i.equals("world")) eq++;
            }

            System.out.println(eq);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
