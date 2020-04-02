package cn.edu.csu.dyp.Persistence;

import cn.edu.csu.dyp.model.user.Address;
import cn.edu.csu.dyp.model.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User login(User user);
    User getUser(String userId);
    Address getAddress(String userId);
    Boolean isUserExist (String username);
    void modifyInfo(User user);
    void modifyPassword(User user);
    void register(User user);

}
