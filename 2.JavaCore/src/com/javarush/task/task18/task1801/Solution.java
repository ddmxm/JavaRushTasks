package com.javarush.task.task18.task1801;

import java.io.*;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int maxByte = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream inputStream = new FileInputStream(reader.readLine())) {
            maxByte = inputStream.read();
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                if (maxByte < data) {
                    maxByte = data;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        System.out.println(maxByte);
    }
}
