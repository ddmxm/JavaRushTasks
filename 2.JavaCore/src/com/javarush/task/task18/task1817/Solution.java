package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer, 0, fileInputStream.available()); // считываем в буфер содержимое файла
            int spaceCount = 0;
            for (int i = 0; i < buffer.length; i++) {
                if (buffer[i] == 32) {
                    spaceCount++;
                }
            }

            float result = (float) spaceCount / buffer.length * 100;
            System.out.println(String.format("%.2f", result));

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
