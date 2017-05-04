package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileReverse(consoleReader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fileReverse(String file) {
        StringBuffer fullStr = new StringBuffer();
        StringBuffer str = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
        ) {
            while (reader.ready()) {
                fullStr.append(str.append(reader.readLine()).reverse() + System.getProperty("line.separator"));
                str.setLength(0);
            }
            System.out.println(fullStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
