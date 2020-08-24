package cn.bdqn.dao.mapper;

import cn.bdqn.beans.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> queryAllUser();
    User getUserByUsername(String username);
}
