package com.javarush.task.task20.task2015;

import java.io.*;

/* 
Переопределение сериализации
*/
public class Solution implements Serializable, Runnable {
    transient private Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, does not matter
        while (true) {
            try {
                Thread.sleep(500);
                System.out.println("working " + this);
            } catch (InterruptedException e) {
            }
        }
    }

    /**
     * Переопределяем сериализацию.
     * Для этого необходимо объявить методы:
     * private void writeObject(ObjectOutputStream out) throws IOException
     * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     * Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.runner = new Thread(this);
        runner.start();
    }

    public static void main(String[] args) {
        new Solution(10);
        try {
            OutputStream output = new FileOutputStream(new File("temp.txt"));
            ObjectOutputStream streamOut = new ObjectOutputStream(output);

            Solution original = new Solution(10);
            streamOut.writeObject(original);

            output.close();
            streamOut.close();

            InputStream input = new FileInputStream(new File("temp.txt"));
            ObjectInputStream streamIn = new ObjectInputStream(input);

            Solution loaded = (Solution) streamIn.readObject();

            input.close();
            streamIn.close();

        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
    }
}

