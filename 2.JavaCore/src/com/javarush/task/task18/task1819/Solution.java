package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            try (FileReader file1Reader = new FileReader(file1);
                 FileReader file2Reader = new FileReader(file2)
            ) {
                String resultFile = "";
                while (file2Reader.ready()) {
                    resultFile += (char) file2Reader.read();
                }

                while (file1Reader.ready()) {
                    resultFile += (char) file1Reader.read();
                }

                try (BufferedWriter file1Writer = new BufferedWriter(new FileWriter(file1))) {
                    file1Writer.write(resultFile);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
