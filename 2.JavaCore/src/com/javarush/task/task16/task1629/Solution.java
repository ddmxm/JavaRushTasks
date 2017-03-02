package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException, IOException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        //add your code here - добавьте код тут
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t1.printResult();
        t2.printResult();

        reader.close();
    }

    //add your code here - добавьте код тут
    public static class Read3Strings extends Thread {
        public String str = "";

        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    if (str.equals("")) {
                        str += reader.readLine();
                    } else {
                        str += " " + reader.readLine();
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        public void printResult() {
            System.out.println(str);
        }
    }
}
