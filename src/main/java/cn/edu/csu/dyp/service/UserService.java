package cn.edu.csu.dyp.service;

import cn.edu.csu.dyp.dao.userDao.*;
import cn.edu.csu.dyp.dao.util.DataBaseDao;
import cn.edu.csu.dyp.model.user.Address;
import cn.edu.csu.dyp.model.user.User;
import cn.edu.csu.dyp.service.util.ModifyInfoStat;
import cn.edu.csu.dyp.service.util.RegisterStat;
import javafx.util.Pair;

public class UserService {

    /*
     * Output
     * 当前用户除密码以外的所有信息，null为失败
     * */
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

    /*
     * Input
     * 所有信息
     * */
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

    /*
    * Input
    * 用户名、密码与旧的一致，userId可为空，电话号码与昵称为修改项
    * Output
    * User:当前用户除密码以外的所有信息，失败为null
    * */
    public Pair<User,ModifyInfoStat> modifyInfo(User user) {//字符合法和密码哈希写在前端
        User res=null;
        ModifyInfoStat resStat=ModifyInfoStat.InternalServerError;
        User oldUser = login(user.getUsername(),user.getPassword());
        if(oldUser == null) {
            resStat=ModifyInfoStat.WrongPassword;
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
                resStat=ModifyInfoStat.NothingChanged;
            }
            else {
                parameter.setUserId(oldUser.getUserId());
                try(DataBaseDao dataBaseDao = new DataBaseDao()) {
                    if(dataBaseDao.query(new ModifyInfoDao(parameter))) {
                        res = dataBaseDao.query(new GetUserDao(oldUser.getUserId()));
                        resStat=ModifyInfoStat.Success;
                    }
                }
            }
        }
        return new Pair<>(res,resStat);
    }

    public ModifyInfoStat modifyPassword(String oldUsername,String oldPassword,String newPassword) {
        ModifyInfoStat res =ModifyInfoStat.InternalServerError;
        User oldUser = login(oldUsername,oldPassword);
        if(oldUser==null) {
            res =ModifyInfoStat.WrongPassword;
        }
        else if(oldPassword.equals(newPassword)) {
            res =ModifyInfoStat.NothingChanged;
        }
        else {
            try(DataBaseDao dataBaseDao = new DataBaseDao()) {
                if(dataBaseDao.query(new ModifyPasswordDao(oldUser.getUserId(),newPassword)))
                    res =ModifyInfoStat.Success;
            }
        }
        return res;
    }

    public Address getAddress(String userId) {
        Address res =null;
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {

        }
        return res;
    }

    /*
    * 没有输入判断，全部替换（因为dyp说是表单）
    * */
    public void setAddress(Address address) {

    }
}
