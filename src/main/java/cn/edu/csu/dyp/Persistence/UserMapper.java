package cn.edu.csu.dyp.Persistence;

import cn.edu.csu.dyp.model.user.Address;
import cn.edu.csu.dyp.model.user.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> getUsers();
    User getUserByUserId(String userId);
    User getUserByUsername(String username);
    User getUserByUsernameAndPassword(User user);
    void insert(User user);
    void update(User user);
    @Deprecated
    Boolean isUserExist (String username);
    Address getAddress(Integer userId);
    void updateAddress(@Param("userId") Integer userId, @Param("address")Address address);
    void setAddress(@Param("userId") Integer userId, @Param("address")Address address);
}
