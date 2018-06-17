package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;
    private static List<Horse> horses = null;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        horses.add(new Horse("Leela", 3, 0));
        horses.add(new Horse("Amy", 3, 0));
        horses.add(new Horse("Tress", 3, 0));
    }
}
