package com.javarush.task.task22.task2202;


/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        //int i = string.lastIndexOf(" ");
        if (string == null || string.isEmpty()) throw new TooShortStringException();
        else {
            String[] s = string.split("\\s");
            if (s.length < 5) {
                throw new TooShortStringException();
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < 5; i++) {
                    sb.append(s[i] + (i == 4 ? "" : " "));
                }
                return sb.toString();
            }
        }
    }


    public static class TooShortStringException extends RuntimeException {
    }
}
