package cn.bdqn.auth.config;

import cn.bdqn.auth.service.MenuService;
import cn.bdqn.auth.service.RoleService;
import cn.bdqn.auth.service.UserService;
import cn.bdqn.beans.pojo.Menu;
import cn.bdqn.beans.pojo.Role;
import cn.bdqn.beans.pojo.User;
import cn.bdqn.util.util.JwtUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;

public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private MenuService menuService;

    /**
     * 必须重写此方法，不然Shiro会报错
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        String username = JwtUtil.getUsername(principalCollection.toString());
        //获取用户
        User user = userService.getUserByUsername(username);
        //获取角色
        List<Role> roleList = roleService.getRoleByUserId(user.getId());
        for (Role role : roleList) {
            simpleAuthorizationInfo.addRole(role.getName());
            //获取权限
            List<Menu> menuList = menuService.getMenuByRoleId(role.getId());
            for (Menu menu : menuList) {
                simpleAuthorizationInfo.addStringPermission(menu.getPattern());//添加 权限
            }
        }
        return simpleAuthorizationInfo;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = null;
        try {
            //这里工具类没有处理空指针等异常这里处理一下(这里处理科学一些)
            username = JwtUtil.getUsername(token);
        } catch (Exception e) {
            throw new AuthenticationException("heard的token拼写错误或者值为空");
        }
        if (username == null) {
            throw new AuthenticationException("token无效");
        }
        User userBean = userService.getUserByUsername(username);
        if (userBean == null) {
            throw new AuthenticationException("用户不存在!");
        }
        if (!JwtUtil.verify(token, username, userBean.getPassword())) {
            throw new AuthenticationException("用户名或密码错误(token无效或者与登录者不匹配)!");
        }
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
