package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
            if (args.length == 4) {
                creatingValue(args, fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void creatingValue(String[] args, String filename) {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filename));
             BufferedReader fileReader = new BufferedReader(new FileReader(filename))
        ) {
            //ищем максимальный ID
            int maxId = Integer.MIN_VALUE;
            List<String> idList = new ArrayList<>();

            while (fileReader.ready()) {
                String line = fileReader.readLine();
                int thisId = Integer.parseInt((line).substring(0, 8).trim());
                idList.add(line);
                if (maxId < thisId) maxId = thisId;
            }
            String finalStr = Integer.toString(++maxId);
            while (finalStr.length() < 8) {
                finalStr += " ";
            }

            if (args[1].length() > 30) {
                args[1] = args[1].substring(0, 30);
            } else while (args[1].length() < 30) {
                args[1] += " ";
            }
            finalStr += args[1];

            if (args[2].length() > 8) {
                args[2].substring(0, 8);
            } else while (args[2].length() < 8) {
                args[2] += " ";
            }
            finalStr += args[2];

            if (args[3].length() > 4) {
                args[3].substring(0,4);
            } else while (args[3].length() < 4) {
                args[3] += " ";
            }
            finalStr += args[3];

            idList.add(finalStr);

            for (String s : idList) {
                fileWriter.write(s + System.getProperty("line.separator"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
