package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String filename = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                filename = reader.readLine();
                try (FileInputStream fileReader = new FileInputStream(filename)) {

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(filename);
            //e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
