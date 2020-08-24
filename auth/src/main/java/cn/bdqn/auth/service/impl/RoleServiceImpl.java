package cn.bdqn.auth.service.impl;

import cn.bdqn.auth.service.RoleService;
import cn.bdqn.beans.pojo.Role;
import cn.bdqn.dao.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Override
    public List<Role> getRoleByUserId(int uid) {
        List<Integer> ridList = roleMapper.getRoleIdByUserId(uid);
        List<Role> roleList = null;
        for (int i=0;i<ridList.size();i++){
            roleList.add(roleMapper.getRoleByRoleId(ridList.get(i)));
        }
        return roleList;
    }
}
