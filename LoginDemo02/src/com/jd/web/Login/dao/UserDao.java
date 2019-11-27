package com.jd.web.Login.dao;

import com.jd.web.Login.domin.User;
import com.jd.web.Login.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDao {

    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());

    public UserDao() {}

    public User queryUser(User u) {
        String sql = "select * from user where username= ? and password= ?";
        List<User> query = template.query(sql, new BeanPropertyRowMapper<User>(User.class), u.getUsername(), u.getPassword());
        if (query.size() > 0) {
            return query.get(0);
        } else {
            return null;
        }

    }

}
