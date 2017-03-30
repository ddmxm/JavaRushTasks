package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName;
            while (true) {
                if (!(fileName = reader.readLine()).equals("exit")) {
                    ReadThread thread = new ReadThread(fileName);
                    thread.start();
                } else break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        int maxValue = Integer.MIN_VALUE;
        int maxKey = Integer.MIN_VALUE;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public synchronized void run() {
            try (FileInputStream fileReader = new FileInputStream(fileName)) {
                Map<Integer, Integer> charMap = new TreeMap<>();

                while (fileReader.available() > 0) {
                    int i = fileReader.read();
                    charMap.put(i, charMap.containsKey(i) ? charMap.get(i) + 1 : 1);
                    if (charMap.get(i) > maxValue) {
                        maxValue = charMap.get(i);
                        maxKey = i;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            synchronized (Solution.class) {
                resultMap.put(this.fileName, maxKey);
            }
        }
    }
}
