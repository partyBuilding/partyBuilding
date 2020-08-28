package cn.bdqn.biz.Service.impl;

import cn.bdqn.beans.bean.Exam;
import cn.bdqn.biz.Service.ExamService;
import cn.bdqn.dao.mapper.ExamMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Resource
    private ExamMapper examMapper;

    @Override
    public boolean addExam(Exam exam) {
        return examMapper.addExam(exam);
    }

    @Override
    public List<Exam> queryExam(Exam exam) {
        return examMapper.queryExam(exam);
    }

    @Override
    public boolean updateExam(Exam exam) {
        return examMapper.updateExam(exam);
    }

    @Override
    public boolean delExam(int id) {
        return examMapper.delExam(id);
    }
}
