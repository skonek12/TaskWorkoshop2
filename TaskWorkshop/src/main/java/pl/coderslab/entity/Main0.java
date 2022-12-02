package pl.coderslab.entity;

import java.sql.SQLException;

public class Main0 {

    public static void main(String[] args) {
//        dodaje nowe
//        User grzeg = new User("Antoni", "macgierewicz@wpisdo.pl","bozenadykiel");
//        UserDao.create(grzeg);

//        odczytuje
//        User user = UserDao.read(3);
//        System.out.println(user.toString());

UserDao userDao = new UserDao();

User user = UserDao.read(3);

user.setUserName("Kastorama");
userDao.update(user);

    }

}
