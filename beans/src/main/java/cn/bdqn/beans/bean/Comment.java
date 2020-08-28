package cn.bdqn.beans.bean;

import lombok.Data;

@Data
public class Comment {
    private int id;
    private String userName;
    private int userId;
    private int documentId;
    private String details;

}
