package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Vasya");
            user.setLastName("Pupkin");
            user.setBirthDate(new Date(1990, 10, 2));
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);

            //User user1 = new User();
            user.setFirstName("Vasya2");
            user.setLastName("Pupkin2");
            user.setBirthDate(new Date(1991, 11, 3));
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);


            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);

            int usersSize = users.size();
            if (usersSize == 0) {
                writer.println(0);
            } else {
                writer.println(usersSize);
                for (User i : users) {
                    StringBuffer user = new StringBuffer();
                    user.append(i.getFirstName() + ";");
                    user.append(i.getLastName() + ";");
                    user.append(i.getBirthDate().getTime() + ";");
                    user.append(Boolean.toString(i.isMale()) + ";");
                    user.append(i.getCountry());
                    writer.println(user.toString());
                }
            }
            writer.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int userSize = Integer.parseInt(reader.readLine());
            if (userSize != 0) {
                for (int i = 0; i < userSize; i++) {
                    User user = new User();
                    String[] strUser = reader.readLine().split(";");
                    user.setFirstName(strUser[0]);
                    user.setLastName(strUser[1]);
                    user.setBirthDate(new Date(Long.parseLong(strUser[2])));
                    user.setMale(Boolean.parseBoolean(strUser[3]));
                    user.setCountry(User.Country.valueOf(strUser[4]));
                    users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
