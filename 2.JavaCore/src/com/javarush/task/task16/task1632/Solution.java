package com.javarush.task.task16.task1632;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new ThreadOne());
        threads.add(new ThreadTwo());
        threads.add(new ThreadThree());
        threads.add(new ThreadFour());
        threads.add(new ThreadFive());
    }

    public static class ThreadOne extends Thread {
        public void run() {
            while (true) {

            }
        }
    }

    public static class ThreadTwo extends Thread {
        public void run() {
            try {
                while (!isInterrupted()) {
                }
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static class ThreadThree extends Thread {
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }


    public static class ThreadFour extends Thread implements Message {
        public void run() {
            while (!isInterrupted()) ;
        }

        @Override
        public void showWarning() {
            interrupt();
            try {
                join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static class ThreadFive extends Thread {
        public void run() {
            String str = "";
            int sum = 0;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                while (true) {
                    str = reader.readLine();
                    if (str.equals("N")) {
                        break;
                    } else {
                        sum += Integer.parseInt(str);
                    }
                }
                System.out.println(sum);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }


    public static void main(String[] args) {
        ThreadOne threadOne = new ThreadOne();
        threadOne.start();

        ThreadTwo threadTwo = new ThreadTwo();
        threadTwo.start();

        ThreadThree threadThree = new ThreadThree();
        threadThree.start();

        ThreadFour threadFour = new ThreadFour();
        threadFour.start();

        ThreadFive threadFive = new ThreadFive();
        threadFive.start();
    }
}