package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine()));
        ) {
            String word = "";
            while (fileReader.ready()) {
                word += String.valueOf((char) fileReader.read());
            }
            word = word.replaceAll("\\p{Punct}","");
            fileWriter.write(word);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
