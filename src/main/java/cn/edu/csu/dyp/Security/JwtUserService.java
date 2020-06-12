package cn.edu.csu.dyp.Security;

import cn.edu.csu.dyp.Persistence.RoleMapper;
import cn.edu.csu.dyp.Persistence.UserMapper;
import cn.edu.csu.dyp.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class JwtUserService implements UserDetailsService {
    private UserMapper userMapper;
    private RoleMapper roleMapper;

    @Autowired
    public JwtUserService(UserMapper userMapper, RoleMapper roleMapper) {
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUserByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User " + username + " Not Found!");
        Collection<GrantedAuthority> roles = roleMapper.getRolesByUserId(user.getUserId())
                .stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        return new JwtUser(user.getUsername(), user.getPassword(), roles);
    }
}
