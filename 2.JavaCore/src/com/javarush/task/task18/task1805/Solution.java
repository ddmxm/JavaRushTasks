package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> readedBytes = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream inputStream = new FileInputStream(reader.readLine())) {
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                readedBytes.put(data, readedBytes.containsKey(data) ? readedBytes.get(data) + 1 : 1);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        for (Map.Entry entry : readedBytes.entrySet()) {
            System.out.print(entry.getKey() + " ");
        }
    }
}
