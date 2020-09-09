package cn.bdqn.dao.mapper;

import cn.bdqn.beans.bean.ExamTopics;
import cn.bdqn.beans.bean.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExamTopicsMapper {

    /**
     * 添加选题和考试的关联
     * @param examTopics
     * @return
     */
    boolean addExamTopics(ExamTopics examTopics);

    List<ExamTopics> getDetails(@Param("examId")int examId);
}
