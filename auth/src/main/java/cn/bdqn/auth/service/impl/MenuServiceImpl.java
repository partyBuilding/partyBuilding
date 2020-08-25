package cn.bdqn.auth.service.impl;

import cn.bdqn.auth.service.MenuService;
import cn.bdqn.beans.pojo.Menu;
import cn.bdqn.dao.mapper.MenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;
    @Override
    public List<Menu> getMenuByRoleId(int rid) {
        List<Integer> midList = menuMapper.getMenuIdByRoleId(rid);
        List<Menu> menuList = new ArrayList<Menu>();
        System.out.println(midList);
        for (int i=0;i<midList.size();i++){
            menuList.add(menuMapper.getMenuByMenuId(midList.get(i)));
        }
        return menuList;
    }
}
