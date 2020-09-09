package cn.bdqn.biz.Service.impl;

import cn.bdqn.beans.bean.Type;
import cn.bdqn.biz.Service.TypeService;
import cn.bdqn.dao.mapper.TypeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TypeServiceImpl implements TypeService {
    @Resource
    private TypeMapper typeMapper;

    @Override
    public List<Type> types() {
        return typeMapper.types();
    }
}
