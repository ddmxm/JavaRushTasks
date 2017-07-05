package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) {
        try {
            Solution solution1 = new Solution("file1");
            solution1.writeObject("Test String1");

            FileOutputStream fos = new FileOutputStream("file1.sav");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(solution1);

            FileInputStream fis = new FileInputStream("file1.sav");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object object = ois.readObject();
            Solution solution2 = (Solution) object;

            solution2.writeObject("Test String2");


        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            e.getMessage();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
