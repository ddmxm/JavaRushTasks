package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) {
        doCopy(args[0], args[1]);
    }

    public static void doCopy(String file1, String file2) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file1));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2));
        ) {
            while (fileReader.ready()) {
                String[] strWords = fileReader.readLine().split(" ");
                for (int i = 0; i < strWords.length; i++) {
                    if (strWords[i].matches(".*\\d\\w.*|.*\\w\\d.*")) {
                        fileWriter.write(strWords[i] + " ");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
