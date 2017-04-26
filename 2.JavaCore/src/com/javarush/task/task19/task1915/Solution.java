package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             FileOutputStream fileWriter = new FileOutputStream(bufferedReader.readLine());
        ) {
            PrintStream consoleStream = System.out; //запоминаем настоящий PrintStream в специальную переменную
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); //Создаем динамический массив
            PrintStream stream = new PrintStream(outputStream);//создаем адаптер к классу PrintStream
            System.setOut(stream);  //Устанавливаем его как текущий System.out
            testString.printSomething(); //Даём поток в консоль
            String result = outputStream.toString(); //Преобразовываем записанные в наш ByteArray данные в строку
            System.setOut(consoleStream);//Возвращаем все как было
            fileWriter.write(result.getBytes());
            System.out.println(result); //выводим строку на консоль с большими буквами

        } catch (Exception e) {

        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

