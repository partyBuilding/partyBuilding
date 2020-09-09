package cn.bdqn.beans.bean;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Exam {
    private int id;
    private String examName;
    private Date examTime;
    private String image;
    private String publisher;
    private int  auditId;    //审核状态的id
    private String statusName; //审核状态的名称
    private String describe;
    private int status;  //状态id
    private String name; //状态名称
    private int titleId;
    private String explain;
    private Date  startTime;;
    private Date endTime;
    private List<ExamTopics> examTopics;  //题目和 考试或调查问卷的关联
    private List<Subject> subjects;   //题目

}
