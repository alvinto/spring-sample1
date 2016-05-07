package com.ws.dao;

import com.ws.entity.User;
import com.ws.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by alvin on 2016/5/7.
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String username,String password){
        String sql = "select count(1) from t_user where user_name = ? and password = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,new Object[]{username,password});
    }

    public User findUserByName(String username){
        String sql = "select user_id,user_name,credits from t_user where user_name = ?";
        final User user = new User();
        jdbcTemplate.query(sql, new Object[]{username}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("user_name"));
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }

    public void updateLoginInfo(User user){
        String sql = "update t_user set last_visit = ?,last_ip = ?,credits = ? where user_id = ?";
        jdbcTemplate.update(sql,new Object[]{DateUtil.formatDate(user.getLastVisit()),user.getLastIp(),user.getCredits(),user.getUserId()});
    }
}
