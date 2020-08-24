package cn.bdqn.auth.controller;

import cn.bdqn.auth.service.UserService;
import cn.bdqn.beans.pojo.LoginUser;
import cn.bdqn.util.util.ResponseDataUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping(value = "/login")
    public Object doLogin(String username,String password){
        LoginUser loginUser = userService.login(username,password);
        if (loginUser != null) {
            return loginUser;
        }
        return ResponseDataUtil.failure("登录失败!");
    }
    @GetMapping(value = "/index")
    public String index(){
        return "index";
    }
}
