package cn.bdqn.auth.service;

import cn.bdqn.beans.pojo.LoginUser;
import cn.bdqn.beans.pojo.User;

public interface UserService {
    LoginUser login(String username, String password);
    User getUserByUsername(String username);
}
