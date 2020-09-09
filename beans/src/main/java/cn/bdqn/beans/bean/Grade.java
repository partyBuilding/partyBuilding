package cn.bdqn.beans.bean;

import lombok.Data;

@Data
public class Grade {
    private int id;
    private int userId;
    private int examId;
    private int grade;
    private String integral;
}
