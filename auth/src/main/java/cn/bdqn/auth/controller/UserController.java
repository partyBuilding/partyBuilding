package cn.bdqn.auth.controller;

import cn.bdqn.auth.service.UserService;
import cn.bdqn.beans.pojo.LoginUser;
import cn.bdqn.beans.pojo.User;
import cn.bdqn.util.util.ResponseDataUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    private UserService userService;


    @GetMapping(value = "/index")
    @RequiresRoles("ROLE_admin")
    public String index(){
        return "index";
    }

    @PostMapping(value = "/login")
    public Object doLogin(String username,String password){
        LoginUser loginUser = userService.login(username,password);
        if (loginUser != null) {
            return loginUser;
        }

        return ResponseDataUtil.failure("登录失败!");
    }

    @PostMapping(value = "/register")
    public Object register(User user){
        if(userService.addUser(user)>0){
            return ResponseDataUtil.success("新增成功");
        }else{
            return ResponseDataUtil.failure("新增失败");
        }
    }
    //退出登录
    @GetMapping("/logout")
    public Object logout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return ResponseDataUtil.success("注销成功");
    }
}
