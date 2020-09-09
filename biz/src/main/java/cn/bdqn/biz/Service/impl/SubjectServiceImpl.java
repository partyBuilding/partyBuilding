package cn.bdqn.biz.Service.impl;

import cn.bdqn.beans.bean.Subject;
import cn.bdqn.biz.Service.SubjectService;
import cn.bdqn.dao.mapper.SubjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Resource
    private SubjectMapper subjectMapper;

    @Override
    public void addSubject(Subject subject) {
        subjectMapper.addSubject(subject);
    }

    @Override
    public boolean del(int id) {
        return subjectMapper.del(id);
    }

    @Override
    public boolean update(Subject subject) {
        return subjectMapper.update(subject);
    }

    @Override
    public List<Subject> select(Subject subject) {
        return subjectMapper.select(subject);
    }
}
