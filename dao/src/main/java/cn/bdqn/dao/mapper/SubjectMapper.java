package cn.bdqn.dao.mapper;

import cn.bdqn.beans.bean.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubjectMapper {
    /**
     * 新增题库实体 并返回自增id在subject的id字段
     * @param
     */
    void addSubject(Subject subject);

    /**
     * 删除题目
     * @param id
     * @return
     */
    boolean del(@Param("id")int id);

    boolean update(Subject subject);

    List<Subject> select(Subject subject);
}
