package com.javarush.task.task19.task1925;

/* 
Длинные слова
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
            StringBuffer fullStr = new StringBuffer();
            while (fileReader.ready()) {
                String[] str = fileReader.readLine().trim().split(" ");
                for (int i = 0; i < str.length; i++) {
                    if (str[i].length() > 6) {
                        fullStr.append(str[i] + ",");
                    }
                }
            }
            fullStr.setLength(fullStr.length() - 1);
            fileWriter.write(fullStr.toString());
        } catch (Exception e) {

        }
    }
}
