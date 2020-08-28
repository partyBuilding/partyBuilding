package cn.bdqn.beans.bean;

import lombok.Data;

import java.util.List;

@Data
public class ExamTopics {
    private int id;
    private int eaxmId;
    private int subjectId;
    private int score;
    private int sort;
    private List<Subject> subjects;
}
