package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = new String(reader.readLine());
        String file2 = new String(reader.readLine());
        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);
        byte[] buffer = new byte[inputStream.available()];
        int count = inputStream.read(buffer);
        for (int i = 0; i < buffer.length / 2; i++) {
            byte temp = buffer[i];
            buffer[i] = buffer[buffer.length - 1 - i];
            buffer[buffer.length - 1 - i] = temp;
        }
        outputStream.write(buffer, 0, count);
        outputStream.close();
        inputStream.close();
    }
}

