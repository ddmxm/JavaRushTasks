package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream file1Reader = new FileInputStream(args[0])) {
            Map<Character, Integer> charMap = new TreeMap<>();
            while (file1Reader.available() > 0) {
                int i = file1Reader.read();
                charMap.put((char) i, charMap.containsKey((char) i) ? charMap.get((char) i) + 1 : 1);
            }

            for (Map.Entry entry : charMap.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
