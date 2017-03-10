package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        String str1 = null, str2 = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            str1 = reader.readLine();
            str2 = reader.readLine();

        } catch (IOException e) {
            System.out.println(e);
        }

        try (BufferedReader br1 = new BufferedReader(new FileReader(str1));
             BufferedReader br2 = new BufferedReader(new FileReader(str2))) {

            String s;
            while ((s = br1.readLine()) != null) {
                allLines.add(s);
            }

            while ((s = br2.readLine()) != null) {
                forRemoveLines.add(s);
            }

            new Solution().joinData();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
