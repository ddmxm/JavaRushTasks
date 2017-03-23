package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            String file3 = reader.readLine();
            try (BufferedWriter file1Writer = new BufferedWriter(new FileWriter(file1));
                 BufferedReader file2Reader = new BufferedReader(new FileReader(file2));
                 BufferedReader file3Reader = new BufferedReader(new FileReader(file3))
            ) {
                String str = null;
                while ((str = file2Reader.readLine()) != null) {
                    file1Writer.write(str);
                }
                while ((str = file3Reader.readLine()) != null) {
                    file1Writer.write(str);
                }
            }
        } catch (
                IOException e)

        {
            System.out.println(e);
        }
    }
}
