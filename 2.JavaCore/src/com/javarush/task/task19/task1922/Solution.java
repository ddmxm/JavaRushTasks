package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        ) {
            parser(consoleReader.readLine());
        } catch (Exception e) {

        }

    }

    public static void parser(String file) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            while (fileReader.ready()) {
                String str = fileReader.readLine();
                String[] strWords = str.trim().split(" ");
                int Qu = 0;
                for (String i : strWords)
                    for (String j : words)
                        if (j.equals(i))
                            Qu++;
                if (Qu == 2) {
                    System.out.println(str);
                }
            }
        } catch (
                Exception e)

        {
            e.printStackTrace();
        }
    }
}
