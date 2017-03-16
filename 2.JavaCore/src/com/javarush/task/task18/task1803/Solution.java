package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int frequentByte = 0;
        Map<Integer, Integer> readedBytes = new HashMap<Integer, Integer>();
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
            if ((Integer) entry.getValue() > frequentByte) {
                frequentByte = (Integer) entry.getValue();
            }
        }

        for (Map.Entry entry : readedBytes.entrySet()) {
            if (entry.getValue().equals(frequentByte)) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
