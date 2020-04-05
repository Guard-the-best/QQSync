package cn.edu.csu.dyp.Service;

import cn.edu.csu.dyp.Persistence.UserMapper;
import cn.edu.csu.dyp.model.user.Address;
import cn.edu.csu.dyp.model.user.User;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
// need hash password
public class UserService {
    private UserMapper userMapper;
//    private static Logger logger=Logger.getLogger(UserService.class);

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User login(String username, String password) {
        if(username==null || password==null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"username and password required");

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

        User res = userMapper.getUserByUsernameAndPassword(user);
        if(res == null){
            if(isUsernameExist(username))
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"username or password error");
            else
                throw  new ResponseStatusException(HttpStatus.UNAUTHORIZED,"username not exist");
        }
        else
            return res;
    }

    public Boolean isUsernameExist(String username) {
        return userMapper.getUserByUsername(username)!=null;
    }

    /*
     * Input
     * 所有信息
     * */
    public User register(User user) {
        if(user.getUsername()==null || user.getPassword()==null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"username and password required");
        else if(isUsernameExist(user.getUsername()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"username used");
        //just a sample
//        else if(user.getUsername().length()<5 && user.getPassword().length()<5)
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"username ans password must include at least 5 character");
        else
            userMapper.insert(user);
        return user;
    }

    public User modifyInfo(User user) {
        if(user.getUsername()==null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"username required");
        else if(!isUsernameExist(user.getUsername()))
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"username not exist");
        else{
            String username = user.getUsername();
            user.setUsername(null);
            user.setPassword(null);
            user.setUserId(userMapper.getUserByUsername(username).getUserId());
            userMapper.update(user);

            return userMapper.getUserByUsername(username);
        }
    }

    public void modifyPassword(String username,String oldPassword,String newPassword) {
        if(username==null || oldPassword==null || newPassword==null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"username and password required");
        else{
            User user = new User();
            user.setUsername(username);
            user.setPassword(oldPassword);
            User res = userMapper.getUserByUsernameAndPassword(user);
            if(res==null)
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"username or password error");
//            else if(newPassword.length()<5)
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"password must include at least 5 character");
            else{
                user.setUserId(res.getUserId());
                user.setUsername(null);
                user.setPassword(newPassword);
                userMapper.update(user);
            }
        }
    }

    public void modifyUsername(String oldUsername,String newUsername,String password) {
        if(oldUsername==null || newUsername==null || password==null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"username and password required");
        else{
            User user = new User();
            user.setUsername(oldUsername);
            user.setPassword(password);
            User res = userMapper.getUserByUsernameAndPassword(user);
            if(res==null)
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"username or password error");
//            else if(newUsername.length()<5)
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"username must include at least 5 character");
            else{
                user.setUserId(res.getUserId());
                user.setUsername(newUsername);
                user.setPassword(null);
                userMapper.update(user);
            }
        }
    }

    public Integer getUserId(String username){
        return userMapper.getUserByUsername(username).getUserId();
    }

    public Address getAddress(Integer userId) {
        return userMapper.getAddress(userId);
    }
//
//    /*
//    * 没有输入判断，全部替换（因为dyp说是表单）
//    * */
//    public Boolean setAddress(String userId, Address address) {
//        return null;
//    }
}
