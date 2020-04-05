package cn.edu.csu.dyp.Persistence;

import cn.edu.csu.dyp.model.user.Address;
import cn.edu.csu.dyp.model.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User getUserByUserId(String userId);
    User getUserByUsername(String username);
    User getUserByUsernameAndPassword(User user);
    void insert(User user);
    void update(User user);
    @Deprecated
    Boolean isUserExist (String username);
    Address getAddress(Integer userId);
}
