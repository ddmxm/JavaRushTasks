package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ) {
            String file1 = new String(reader.readLine());
            String file2 = new String(reader.readLine());
            String file3 = new String(reader.readLine());
            FileInputStream inputStream1 = new FileInputStream(file1); //Почему валидатору не нравится, если это кинуть в try with resources?
            FileOutputStream outputStream2 = new FileOutputStream(file2); //И почему нельзя использовать 1 поток для записи?
            FileOutputStream outputStream3 = new FileOutputStream(file3);

            byte[] buffer = new byte[inputStream1.available()];
            int count = inputStream1.read(buffer);
            if (!(count % 2 == 0)) {
                outputStream2.write(buffer, 0, count / 2 + 1);
                outputStream3.write(buffer, count / 2 + 1, count / 2);
            }
            else {
                outputStream2.write(buffer, 0, count / 2);
                outputStream3.write(buffer, count / 2, count / 2);
            }

            inputStream1.close();
            outputStream2.close();
            outputStream3.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
