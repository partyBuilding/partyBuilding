package cn.bdqn.auth.service;

import cn.bdqn.beans.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoleByUserId(int uid);
}
