package cn.bdqn.auth.service;

import cn.bdqn.beans.pojo.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenuByRoleId(int rid);
}
