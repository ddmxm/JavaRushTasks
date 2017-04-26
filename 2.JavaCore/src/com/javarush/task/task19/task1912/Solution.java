package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
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
        String result = outputStream.toString(); //Преобразовываем записанные в наш ByteArray данные в строку
        System.setOut(consoleStream);//Возвращаем все как было
        System.out.println(result.replaceAll("te", "??")); //выводим строку на консоль с заменой по регулярному выражению
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
