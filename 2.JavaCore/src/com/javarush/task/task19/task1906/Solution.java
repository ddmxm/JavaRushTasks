package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader = new FileReader(bufferedReader.readLine());
             FileWriter fileWriter = new FileWriter(bufferedReader.readLine())
        ) {
            for (int i = 1; fileReader.ready(); i++ ) {
                if (i % 2 == 0) {
                    fileWriter.write(fileReader.read());
                } else fileReader.read();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
