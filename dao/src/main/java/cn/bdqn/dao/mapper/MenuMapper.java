package cn.bdqn.dao.mapper;

import cn.bdqn.beans.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {
    //根据角色id查看拥有的权限
    List<Integer> getMenuIdByRoleId(@Param("rid") int rid);
    //根据权限id查看权限
    Menu getMenuByMenuId(@Param("mid")int mid);

}
