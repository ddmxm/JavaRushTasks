package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            firstFileName = bufferedReader.readLine();
            secondFileName = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String textFile);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        String textFile;
        String fileToStr = "";

        @Override
        public void setFileName(String textFile) {
            this.textFile = textFile;
        }

        @Override
        public String getFileContent() {
            return fileToStr;
        }

        public void run() {
            try (BufferedReader filereader = new BufferedReader(new FileReader(textFile))) {
                String textBuf;
                while ((textBuf = filereader.readLine()) != null) {
                    if (fileToStr.equals("")) {
                        fileToStr += textBuf;
                    } else {
                        fileToStr += " " + textBuf;
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println(e);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}