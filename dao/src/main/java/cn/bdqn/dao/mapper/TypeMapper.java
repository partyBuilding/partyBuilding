package cn.bdqn.dao.mapper;

import cn.bdqn.beans.bean.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeMapper {
    /**
     * 查询文档分类表
     * @return
     */
    List<Type> types();
}
