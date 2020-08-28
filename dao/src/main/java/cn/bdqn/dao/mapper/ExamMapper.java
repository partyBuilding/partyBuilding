package cn.bdqn.dao.mapper;

import cn.bdqn.beans.bean.Exam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExamMapper {
    /**
     * 新增考试
     * @param exam
     * @return
     */
    boolean addExam(Exam exam);

    /**
     * 条件查询考试
     * @param exam
     * @return
     */
    List<Exam> queryExam(Exam exam);

    /**
     * 修改考试信息
     * @param exam
     * @return
     */
    boolean updateExam(Exam exam);

    boolean delExam(@Param("id")int id);
}
