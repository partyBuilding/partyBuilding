package cn.bdqn.dao;

import cn.bdqn.dao.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DaoApplicationTests {
    @Resource
    UserMapper userMapper;
    @Test
    public void queryAllUser(){
        System.out.println(userMapper.queryAllUser());
    }

}
