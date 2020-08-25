package cn.bdqn.auth.service;

import cn.bdqn.beans.pojo.LoginUser;
import cn.bdqn.beans.pojo.User;

public interface UserService {
    //用户登录 返回带token的用户
    LoginUser login(String username, String password);
    //根据用户名获取用户
    User getUserByUsername(String username);
    //新增用户
    int addUser(User user);
}
