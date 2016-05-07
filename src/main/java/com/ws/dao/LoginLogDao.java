package com.ws.dao;

import com.ws.entity.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by alvin on 2016/5/7.
 */
@Repository
public class LoginLogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLoginLog(LoginLog loginLog){
        String sql = "insert into t_login_log (user_id,ip,login_date) values (?,?,?)";
        jdbcTemplate.update(sql,new Object[]{loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDate()});
    }
}
