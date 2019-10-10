package cn.edu.csu.dyp.service;

import cn.edu.csu.dyp.dao.userDao.LoginDao;
import cn.edu.csu.dyp.dao.util.DataBaseDao;

public class UserService {
    private static final String loginQuery="select password from test where username=?";//need modify!!!!!!!!!!

    public boolean login(String username,String password) {
        try(DataBaseDao dataBaseDAO = new DataBaseDao()) {
            if(dataBaseDAO.query(loginQuery, new LoginDao(username,password)))
                return true;
        }
        return false;
    }
}
