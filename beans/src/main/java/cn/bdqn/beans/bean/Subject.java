package cn.bdqn.beans.bean;

import lombok.Data;

import java.util.List;

@Data
public class Subject {
    private int id;
    private String name;
    private String publisher;
    private int topicType;
    private int auditId;
    private String describe;
    private List<Options> options;   //接收前端的选项数据

}
