package com.ws.service;

import com.ws.dao.LoginLogDao;
import com.ws.entity.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alvin on 2016/5/7.
 */
@Service
public class LoginLogService {
    @Autowired
    private LoginLogDao loginLogDao;

    public void insertLoginLog(LoginLog loginLog){
        loginLogDao.insertLoginLog(loginLog);
    }
}
