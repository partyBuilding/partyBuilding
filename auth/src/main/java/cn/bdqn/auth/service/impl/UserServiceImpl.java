package cn.bdqn.auth.service.impl;

import cn.bdqn.auth.service.UserService;
import cn.bdqn.beans.pojo.LoginUser;
import cn.bdqn.beans.pojo.User;
import cn.bdqn.dao.mapper.UserMapper;
import cn.bdqn.util.util.JwtUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public LoginUser login(String username, String password) {
        LoginUser loginUser=new LoginUser();
        String token = JwtUtil.sign(username,password);
        loginUser.setUser(userMapper.getUserByUsername(username));
        loginUser.setToken(token);
        return loginUser;
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }
}
