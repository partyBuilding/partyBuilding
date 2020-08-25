package cn.bdqn.dao.mapper;

import cn.bdqn.beans.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {
    //根据用户id查询拥有的角色
    List<Integer> getRoleIdByUserId(@Param("uid") int uid);
    //根据角色id查询角色
    Role getRoleByRoleId(@Param("rid") int rid);
}
