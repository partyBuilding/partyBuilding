package cn.bdqn.dao.mapper;

import cn.bdqn.beans.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    List<Integer> getRoleIdByUserId(int uid);
    Role getRoleByRoleId(int rid);
}
