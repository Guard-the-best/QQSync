package cn.edu.csu.dyp.Persistence;

import cn.edu.csu.dyp.model.Address;
import cn.edu.csu.dyp.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User login(User user);
    User getUser(String userId);
    Address getAddress(String userId);
    Boolean isUserExist (String username);
    void modifyInfo(User user);
}
