package com.yurets_y.core.hibernate.hibernate_simple_example;

import com.yurets_y.core.hibernate.hibernate_simple_example.entity.Auto;
import com.yurets_y.core.hibernate.hibernate_simple_example.entity.User;
import com.yurets_y.core.hibernate.hibernate_simple_example.dao.UserDao;

public class HibernateSimpleExample {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = new User("Masha",26);
        userDao.save(user);
        Auto ferrari = new Auto("Ferrari", "red");
        ferrari.setUser(user);
        user.addAuto(ferrari);
        Auto ford = new Auto("Ford", "black");
        ford.setUser(user);
        user.addAuto(ford);
        userDao.update(user);
    }
}
