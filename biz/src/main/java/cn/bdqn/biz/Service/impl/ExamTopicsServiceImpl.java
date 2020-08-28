package cn.bdqn.biz.Service.impl;

import cn.bdqn.beans.bean.ExamTopics;
import cn.bdqn.biz.Service.ExamTopicsService;
import cn.bdqn.dao.mapper.ExamTopicsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExamTopicsServiceImpl implements ExamTopicsService {
    @Resource
    private ExamTopicsMapper examTopicsMapper;
    @Override
    public boolean addExamTopics(ExamTopics examTopics) {
        return examTopicsMapper.addExamTopics(examTopics);
    }

    @Override
    public List<ExamTopics> getDetails(int examId) {
        return examTopicsMapper.getDetails(examId);
    }
}
