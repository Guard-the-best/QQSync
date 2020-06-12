package cn.edu.csu.dyp.Persistence;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    List<String> getRolesByUserId(Integer userId);
    void addRoles(@Param("userId") Integer userId,@Param("role")String role);
    void deleteRoles(Integer userId);
}
