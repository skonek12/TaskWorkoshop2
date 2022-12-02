package pl.coderslab.entity;

import java.sql.SQLException;
import java.util.Arrays;

import static pl.coderslab.entity.UserDao.findAll;

public class Main0 {

    public static void main(String[] args) {
//        dodaje nowe
//        User grzeg = new User("Stanisłasdw", "kasdbao@do.pl","bozenadykiel");
//        UserDao.create(grzeg);

//        odczytuje
//        User user = UserDao.read(5);
//        System.out.println(user.toString());


//        Updatuje
//        UserDao userDao = new UserDao();
//        User user = UserDao.read(5);
//        user.setUserName("Kastorama");
//        userDao.update(user);

//        Kasuje
        UserDao.delete(4);


//        UserDao userDao = new UserDao();
//        System.out.println(Arrays.toString(findAll()));




    }

}
