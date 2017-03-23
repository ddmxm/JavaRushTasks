package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            ArrayList<Double> numberList = new ArrayList<>();
            try (FileInputStream file1Reader = new FileInputStream(file1);
                 FileWriter file2Writer = new FileWriter(file2)
            ) {
                String number = "";
                char symbol;
                byte[] buffer = new byte[file1Reader.available()];
                if (file1Reader.available() > 0) {
                    file1Reader.read(buffer);
                }

                for (int i = 0; i < buffer.length; i++) {
                    symbol = (char) buffer[i];
                    if (i == buffer.length - 1) {
                        number += symbol;
                        numberList.add(Double.parseDouble(number));
                        number = "";
                    } else if (symbol != '\u0020' && symbol != '\n') {
                        number += symbol;
                    } else {
                        numberList.add(Double.parseDouble(number));
                        number = "";
                    }
                }
                for (Double i : numberList) {
                    file2Writer.write(Math.round(i) + " ");
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
