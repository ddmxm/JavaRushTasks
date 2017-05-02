package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        try {
            System.out.print(MostRich(args[0]));
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public static String MostRich(String file) {
        StringBuffer Richy = new StringBuffer();

        Double max = Double.MIN_VALUE;
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            Map<String, Double> map = new HashMap<>();
            while (fileReader.ready()) {
                String[] str = fileReader.readLine().trim().split(" ");
                String name = str[0];
                Double money = Double.valueOf(str[1]);
                map.put(name, map.containsKey(name) ? map.get(name) + money : money);
            }

            for (Map.Entry<String, Double> entry : map.entrySet()) {
                if (entry.getValue().equals(max)) {
                    Richy.append(entry.getKey() + "\n");
                } else if (entry.getValue() > max) {
                    max = entry.getValue();
                    Richy.setLength(0);
                    Richy.append(entry.getKey() + "\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Richy.toString();
    }
}
