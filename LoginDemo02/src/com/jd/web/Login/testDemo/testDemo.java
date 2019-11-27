package com.jd.web.Login.testDemo;

import com.jd.web.Login.dao.UserDao;
import com.jd.web.Login.domin.User;
import org.junit.Test;

public class testDemo {
    @Test
    public void query(){
        UserDao UserDao = new UserDao();
        System.out.println(UserDao);
        User u = new User("zhangsan", "123");
        User user = UserDao.queryUser(u);
        System.out.println(user);
    }
    @Test
    public void test01(){
        UserDao userDao = new UserDao();
        System.out.println(userDao);
    }
}
