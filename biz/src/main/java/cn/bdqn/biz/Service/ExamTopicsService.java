package cn.bdqn.biz.Service;

import cn.bdqn.beans.bean.ExamTopics;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamTopicsService {
    /**
     * 添加选题和考试的关联
     * @param examTopics
     * @return
     */
    boolean addExamTopics(ExamTopics examTopics);

    List<ExamTopics> getDetails(@Param("examId")int examId);
}
