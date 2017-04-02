package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) {

        switch (args[0]) {
            case ("-e"):
                encryptFile(args[1], args[2]);
                break;
            case ("-d"):
                decryptFile(args[1], args[2]);
                break;
            default:
                break;
        }
    }

    static void encryptFile(String fileInput, String fileOutput) {
        try (FileInputStream fileReader = new FileInputStream(fileInput);
             FileOutputStream fileWriter = new FileOutputStream(fileOutput);
        ) {
            while (fileReader.available() > 0) {
                int count = fileReader.read();
                fileWriter.write(count + 1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void decryptFile(String fileInput, String fileOutput) {

        try (FileInputStream fileReader = new FileInputStream(fileInput);
             FileOutputStream fileWriter = new FileOutputStream(fileOutput);
        ) {
            while (fileReader.available() > 0) {
                int count = fileReader.read();
                fileWriter.write(count - 1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
