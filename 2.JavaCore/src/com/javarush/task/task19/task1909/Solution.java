package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine()));
        ) {
            while (fileReader.ready()) {
                char c = (char) fileReader.read();
                if (c == '.') {
                    fileWriter.write((int) '!');
                } else {
                    fileWriter.write((int) c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
