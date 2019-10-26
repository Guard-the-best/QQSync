package cn.edu.csu.dyp.service;

import cn.edu.csu.dyp.dao.userDao.IsUserExistDao;
import cn.edu.csu.dyp.dao.userDao.LoginDao;
import cn.edu.csu.dyp.dao.userDao.ModifyInfoDao;
import cn.edu.csu.dyp.dao.userDao.RegisterDao;
import cn.edu.csu.dyp.dao.util.DataBaseDao;
import cn.edu.csu.dyp.model.User;
import cn.edu.csu.dyp.service.util.ModifyInfoStat;
import cn.edu.csu.dyp.service.util.RegisterStat;

public class UserService {

    public User login(String username, String password) {
        User user;
        try(DataBaseDao dataBaseDAO = new DataBaseDao()) {
           user=dataBaseDAO.query(new LoginDao(username,password));
        }
        return user;
    }

    public Boolean isUsernameExist(String username) {
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            if(dataBaseDao.query(new IsUserExistDao(username))) {
                return true;
            }
        }
        return false;
    }

    public RegisterStat register(User user) {//字符合法和密码哈希写在前端
        RegisterStat res=RegisterStat.InternalServerError;
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            if(dataBaseDao.query(new IsUserExistDao(user.getUsername())))
                res=RegisterStat.UsernameUsed;
            else if(dataBaseDao.query(new RegisterDao(user))) {
                res=RegisterStat.Success;
            }
        }
        return res;
    }

    public ModifyInfoStat modifyInfo(User user) {//字符合法和密码哈希写在前端
        ModifyInfoStat res=ModifyInfoStat.InternalServerError;
        User oldUser = login(user.getUsername(),user.getPassword());
        if(oldUser == null) {
            res=ModifyInfoStat.WrongPassword;
        }
        else {
            User parameter = new User();
            boolean modified=false;
            if(user.getPhoneNumber()!=null && !user.getPhoneNumber().equals(oldUser.getPhoneNumber())) {
                modified=true;
                parameter.setPhoneNumber(user.getPhoneNumber());
            }
            if(user.getNickname()!=null && !user.getNickname().equals(oldUser.getNickname())) {
                modified=true;
                parameter.setNickname(user.getNickname());
            }

            if(!modified){
                res=ModifyInfoStat.NothingChanged;
            }
            else {
                parameter.setUserId(oldUser.getUserId());
                try(DataBaseDao dataBaseDao = new DataBaseDao()) {
                    if(dataBaseDao.query(new ModifyInfoDao(parameter)))
                        res=ModifyInfoStat.Success;
                }
            }
        }
        return res;
    }

}
