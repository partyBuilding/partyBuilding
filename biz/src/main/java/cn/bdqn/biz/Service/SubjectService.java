package cn.bdqn.biz.Service;

import cn.bdqn.beans.bean.Subject;

import java.util.List;

public interface SubjectService {
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
    boolean del(int id);

    boolean update(Subject subject);

    List<Subject> select(Subject subject);
}
