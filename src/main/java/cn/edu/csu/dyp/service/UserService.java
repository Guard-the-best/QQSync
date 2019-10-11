package cn.edu.csu.dyp.service;

import cn.edu.csu.dyp.dao.userDao.IsUserExistDao;
import cn.edu.csu.dyp.dao.userDao.LoginDao;
import cn.edu.csu.dyp.dao.userDao.RegisterDao;
import cn.edu.csu.dyp.dao.util.DataBaseDao;
import cn.edu.csu.dyp.model.User;
import cn.edu.csu.dyp.service.util.RegisterStat;

public class UserService {

    public User login(String username, String password) {
        User user;
        try(DataBaseDao<User> dataBaseDAO = new DataBaseDao<>()) {
           user=dataBaseDAO.query(LoginDao.loginQuery, new LoginDao(username,password));
        }
        return user;
    }

    public RegisterStat register(User user) {//字符合法和密码哈希写在前端
        RegisterStat res=RegisterStat.InternalServerError;
        try(DataBaseDao<Boolean> dataBaseDao = new DataBaseDao<>()) {
            if(dataBaseDao.query(IsUserExistDao.isUserExistQuery,new IsUserExistDao(user.getUsername())))
                res=RegisterStat.UsernameUsed;
            else if(dataBaseDao.query(new RegisterDao(user))) {
                res=RegisterStat.Success;
            }
        }
        return res;
    }

}
