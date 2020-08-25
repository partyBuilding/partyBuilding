package cn.bdqn.dao.mapper;

import cn.bdqn.beans.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    //查询所有用户
    List<User> queryAllUser();
    //根据用户名查询用户
    User getUserByUsername(@Param("username") String username);
    //新增用户
    int addUser(User user);

}
