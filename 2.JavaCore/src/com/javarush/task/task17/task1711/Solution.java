package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    private static SimpleDateFormat format = new SimpleDateFormat("dd/M/yyyy");

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    try {
                        createPerson(args);
                        break;
                    } catch (ParseException e) {
                        System.out.println(e);
                        break;
                    }
                }
            case "-u":
                synchronized (allPeople) {
                    try {
                        updatePerson(args);
                        break;
                    } catch (ParseException e) {
                        System.out.println(e);
                        break;
                    }
                }
            case "-d":
                synchronized (allPeople) {
                    try {
                        deletePerson(args);
                        break;
                    } catch (ParseException e) {
                        System.out.println(e);
                        break;
                    }
                }
            case "-i":
                synchronized (allPeople) {
                    int i = 1;
                    do {
                        StringBuilder s = new StringBuilder();
                        Person p = allPeople.get(Integer.valueOf(args[i++]));
                        s.append(p.getName()).append(" ");
                        if (p.getSex() == Sex.MALE) {
                            s.append("м").append(" ");
                        } else {
                            s.append("ж").append(" ");
                        }
                        s.append(format.format(p.getBirthDay()));
                        System.out.println(s);
                    } while (i < args.length);
                    break;
                }
        }
    }

    private synchronized static void createPerson(String[] args) throws ParseException {
        int i = 1;
        do {
            String name = args[i++];
            String sex = args[i++];
            Date date = format.parse(args[i++]);
            if (sex.equals("м")) {
                allPeople.add(Person.createMale(name, date));
                System.out.println(allPeople.size() - 1);
            } else {
                allPeople.add(Person.createFemale(name, date));
                System.out.println(allPeople.size() - 1);
            }
        }
        while (i < args.length);

    }

    private synchronized static void updatePerson(String[] args) throws ParseException {
        int i = 1;
        do {
            int id = Integer.valueOf(args[i++]);
            String name = args[i++];
            String sex = args[i++];
            Date date = format.parse(args[i++]);

            Person p = allPeople.get(id);
            p.setName(name);
            if (sex.equals("м")) {
                p.setSex(Sex.MALE);
            } else {
                p.setSex(Sex.FEMALE);
            }
            p.setBirthDay(date);
        } while (i < args.length);
    }

    private synchronized static void deletePerson(String[] args) throws ParseException {
        int i = 1;
        do {
            Person p = allPeople.get(Integer.valueOf(args[i++]));
            p.setName(null);
            p.setSex(null);
            p.setBirthDay(null);
        } while (i < args.length);
    }
}
