package com.javarush.task.task22.task2203;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null || string.isEmpty() || !(string.matches(".*\\t.*\\t.*")))
            throw new TooShortStringException();
        else {
            Matcher m = Pattern.compile("\\t.*?\\t").matcher(string);
            m.find();
            return m.group().replaceAll("\\t", "");
        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}