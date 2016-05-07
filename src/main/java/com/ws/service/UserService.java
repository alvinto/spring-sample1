package com.ws.service;

import com.ws.dao.LoginLogDao;
import com.ws.dao.UserDao;
import com.ws.entity.LoginLog;
import com.ws.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alvin on 2016/5/7.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginLogDao loginLogDao;

    /**
     * 查询是否有匹配的用户
     * @param username
     * @param password
     * @return
     */
    public boolean hasMatchUser(String username,String password){
        int i = userDao.getMatchCount(username, password);
        return i>0;
    }

    public User findUserByName(String username){
        return userDao.findUserByName(username);
    }

    public void loginSuccess(User user){
        user.setCredits(5+user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }
}
