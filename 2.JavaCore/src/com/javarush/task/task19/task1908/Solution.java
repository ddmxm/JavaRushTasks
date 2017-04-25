package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine()));
        ) {
            String word = "";
            while (fileReader.ready()) {
                String[] words = fileReader.readLine().split(" ");
                for (int i = 0; i < words.length; i++) {
                    try {
                        Integer.parseInt(words[i]);
                        word += words[i] + " ";
                    } catch (NumberFormatException e) {

                    }
                }
                fileWriter.write(word);
                word = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
