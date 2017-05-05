package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));


        StringBuilder sb = new StringBuilder();
        while (fileReader.ready()) {
            sb.append(fileReader.readLine());
        }
        reader.close();
        fileReader.close();
        String string = sb.toString().replaceAll("[\r\n]", "");
        if (args[0].length() >= 1)
            printTags(string, args[0]);
    }

    public static void printTags(String string, String tag) {
        int beginIndex = 0;
        int offIndex = 0;
        int beginCount = 0;
        int offCount = 0;
        boolean stop = false;
        while (!stop) {
            char[] c = string.toCharArray();
            for (int i = 0; i < c.length - tag.length() - 2; i++) {
                String s = new String(c, i, tag.length() + 2);
                if ((("<" + tag + ">").equalsIgnoreCase(s)) || (("<" + tag + " ").equalsIgnoreCase(s))) {
                    if (beginCount == 0)
                        beginIndex = i;
                    beginCount++;
                }
                s = new String(c, i, tag.length() + 3);
                if ((("</" + tag + ">").equalsIgnoreCase(s))
                        & beginCount != 0) {
                    offCount++;
                    if (beginCount == offCount)
                        offIndex = i;
                }
                if (beginCount == offCount & beginCount != 0) {
                    s = string.substring(beginIndex, offIndex + tag.length() + 3);
                    System.out.println(s);
                    string = string.substring(beginIndex + tag.length() + 2);
                    beginCount = 0;
                    offCount = 0;
                    break;
                }
                stop = ((i >= c.length - tag.length() - 2) & offCount == 0 | beginCount == 0);
            }
        }
    }
}