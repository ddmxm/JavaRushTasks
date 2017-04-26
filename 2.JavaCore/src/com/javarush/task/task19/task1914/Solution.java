package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out; //запоминаем настоящий PrintStream в специальную переменную
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); //Создаем динамический массив
        PrintStream stream = new PrintStream(outputStream);//создаем адаптер к классу PrintStream
        System.setOut(stream);  //Устанавливаем его как текущий System.out
        testString.printSomething(); //Даём поток в консоль
        String result;// = outputStream.toString(); //Преобразовываем записанные в наш ByteArray данные в строку
        String[] arr = outputStream.toString().trim().split(" ");
        int res = 0;
        switch (arr[1]) {
            case "+":
                res = Integer.valueOf(arr[0]) + Integer.valueOf(arr[2]);
                break;
            case "-":
                res = Integer.valueOf(arr[0]) - Integer.valueOf(arr[2]);
                break;
            case "*":
                res = Integer.valueOf(arr[0]) * Integer.valueOf(arr[2]);
                break;
        }
        System.setOut(consoleStream);//Возвращаем все как было
        System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " = " + res); //выводим строку на консоль с заменой по регулярному выражению
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

