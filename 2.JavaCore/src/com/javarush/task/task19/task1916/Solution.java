package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader1 = new BufferedReader(new FileReader(consoleReader.readLine()));
             BufferedReader fileReader2 = new BufferedReader(new FileReader(consoleReader.readLine()));
        ) {
            List<String> fileArr1 = new ArrayList<>();
            List<String> fileArr2 = new ArrayList<>();

            while (fileReader1.ready()) {
                fileArr1.add(fileReader1.readLine());
            }

            while (fileReader2.ready()) {
                fileArr2.add(fileReader2.readLine());
            }

            for (int i = 0, j = 0; i < fileArr1.size() - 1 || j < fileArr2.size() - 1; i++, j++) {
                if (fileArr1.get(i).equals(fileArr2.get(j))) {
                    lines.add(new LineItem(Type.SAME, fileArr1.get(i)));
                } else if (fileArr1.get(i).equals(fileArr2.get(j + 1))) {
                    lines.add(new LineItem(Type.ADDED, fileArr2.get(j)));
                    i--;
                } else if (fileArr1.get(i + 1).equals(fileArr2.get(j))) {
                    lines.add(new LineItem(Type.REMOVED, fileArr1.get(i)));
                    j--;
                }

                if (i == fileArr1.size() - 2 && j == fileArr2.size() - 1) {
                    lines.add(new LineItem(Type.REMOVED, fileArr1.get(i + 1)));
                }
                if (i == fileArr1.size() - 1 && j == fileArr2.size() - 2) {
                    lines.add(new LineItem(Type.ADDED, fileArr2.get(j + 1)));
                }
            }

            for (LineItem i : lines) {
                System.out.println(i.type + " " + i.line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
