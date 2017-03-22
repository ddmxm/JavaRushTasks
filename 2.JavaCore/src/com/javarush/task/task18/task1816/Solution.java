package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer, 0, fileInputStream.available()); // считываем в буфер содержимое файла
            int count = 0;
            for (int i = 0; i < buffer.length; i++) {
                if (Character.isAlphabetic(buffer[i])) {count++;}
            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
