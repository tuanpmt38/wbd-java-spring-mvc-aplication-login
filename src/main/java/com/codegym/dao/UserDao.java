package com.codegym.dao;

import com.codegym.model.Login;
import com.codegym.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> users;
    static {
        users = new ArrayList<>();
        User u1 = new User();
        u1.setAccount("jonh");
        u1.setPassword("123456");
        u1.setName("Jonh");
        u1.setEmail("Jonh@gmail.com");
        u1.setAge(10);
        users.add(u1);

        User u2 = new User();
        u2.setAccount("petter");
        u2.setPassword("123456");
        u2.setName("Petter");
        u2.setEmail("petter@gmail.com");
        u2.setAge(20);
        users.add(u2);

        User u3 = new User();
        u3.setAge(16);
        u3.setName("Mike");
        u3.setAccount("mike");
        u2.setEmail("mike@codegym.vn");
        u3.setPassword("123456");
        users.add(u3);
    }

    public static User checkLogin(Login login){
        for(User u : users){
            if(u.getAccount().equals(login.getAccount())&&u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}
