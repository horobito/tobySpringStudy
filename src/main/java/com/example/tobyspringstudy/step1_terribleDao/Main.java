package com.example.tobyspringstudy.step1_terribleDao;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();

        User user = new User();
        user.setId("1");
        user.setName("horobito1");
        user.setPassword("pwd1");

        userDao.add(user);

        System.out.println("유저 아이디 : " + user.getId() + " 등록 성공");

        User receivedUser = userDao.get(user.getId());
        System.out.println(receivedUser.getName());
        System.out.println(receivedUser.getPassword());
        System.out.println("유저 아이디 : " + receivedUser.getId() + " 등록 성공");

    }
}
