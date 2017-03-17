package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream;

        while (true) {
            inputStream = new FileInputStream(new File(reader.readLine()));
            if (inputStream.available() < 1000) {
                inputStream.close();
                reader.close();
                throw new DownloadException();
            }
            inputStream.close();
        }
    }

    public static class DownloadException extends Exception {

    }
}
