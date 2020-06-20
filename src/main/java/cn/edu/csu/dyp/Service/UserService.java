package cn.edu.csu.dyp.Service;

import cn.edu.csu.dyp.Persistence.RoleMapper;
import cn.edu.csu.dyp.Persistence.UserMapper;
import cn.edu.csu.dyp.Security.JwtUserService;
import cn.edu.csu.dyp.Security.JwtUtil;
import cn.edu.csu.dyp.model.user.Address;
import cn.edu.csu.dyp.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
// need hash password
public class UserService {
    private UserMapper userMapper;
    private RoleMapper roleMapper;
    private AuthenticationManager authenticationManager;
    private JwtUserService jwtUserService;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//    private static Logger logger=Logger.getLogger(UserService.class);

    @Autowired
    public UserService(UserMapper userMapper, RoleMapper roleMapper, AuthenticationManager authenticationManager, JwtUserService jwtUserService) {
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
        this.authenticationManager = authenticationManager;
        this.jwtUserService = jwtUserService;
    }

    public String login(String username, String password) {
        User res = userMapper.getUserByUsername(username);
        if (!passwordEncoder.matches(password, res.getPassword())) {
            if (isUsernameExist(username))
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "username or password error");
            else
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "username not exist");
        } else {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            return JwtUtil.newToken(jwtUserService.loadUserByUsername(username));
        }
    }

    public Boolean isUsernameExist(String username) {
        return userMapper.getUserByUsername(username) != null;
    }

    /*
     * Input
     * 所有信息
     * */
    public void register(User user) {
        if (isUsernameExist(user.getUsername()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "username used");
            //just a sample
//        else if(user.getUsername().length()<5 && user.getPassword().length()<5)
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"username ans password must include at least 5 character");
        else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userMapper.insert(user);
        }
    }

    public User modifyInfo(User user) {
        if (!isUsernameExist(user.getUsername()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "username not exist");
        else {
            String username = user.getUsername();
            user.setUserId(userMapper.getUserByUsername(username).getUserId());
            userMapper.update(user);

            return userMapper.getUserByUsername(username);
        }
    }

    public void modifyPassword(String username, String oldPassword, String newPassword) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(oldPassword);
        User res = userMapper.getUserByUsernameAndPassword(user);
        if (res == null)
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "username or password error");
//            else if(newPassword.length()<5)
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"password must include at least 5 character");
        else {
            user.setUserId(res.getUserId());
            user.setUsername(null);
            user.setPassword(passwordEncoder.encode(newPassword));
            userMapper.update(user);
        }
    }

    public void modifyUsername(String oldUsername, String newUsername, String password) {
        User user = new User();
        user.setUsername(oldUsername);
        user.setPassword(password);
        User res = userMapper.getUserByUsernameAndPassword(user);
        if (res == null)
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "username or password error");
//            else if(newUsername.length()<5)
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"username must include at least 5 character");
        else {
            user.setUserId(res.getUserId());
            user.setUsername(newUsername);
            user.setPassword(null);
            userMapper.update(user);
        }
    }

    public User getUser(String username){
        return userMapper.getUserByUsername(username);
    }

    public Integer getUserId(String username) {
        return userMapper.getUserByUsername(username).getUserId();
    }

    public Address getAddress(Integer userId) {
        return userMapper.getAddress(userId);
    }

    public void setAddress(Integer userId, Address address) {
        if (getAddress(userId) == null)
            userMapper.setAddress(userId, address);
        else
            userMapper.updateAddress(userId, address);
    }
//
//    /*
//    * 没有输入判断，全部替换（因为dyp说是表单）
//    * */
//    public Boolean setAddress(String userId, Address address) {
//        return null;
//    }

    @Transactional
    public void addRole(Integer userId, String[] roles) {
        for(String role:roles){
            if(role.startsWith("ROLE_"))
                roleMapper.addRoles(userId,role);
        }
    }

    public void deleteRole(Integer userId) {
        roleMapper.deleteRoles(userId);
    }

    public void newRoles(Integer userId, String[] roles){
        deleteRole(userId);
        addRole(userId,roles);
    }

    public List<String> getRoles(Integer userId) {
        return roleMapper.getRolesByUserId(userId);
    }
}
