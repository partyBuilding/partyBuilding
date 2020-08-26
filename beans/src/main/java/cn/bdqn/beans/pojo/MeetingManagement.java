package cn.bdqn.beans.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class MeetingManagement {
    private int id;
    private String title;
    private Date startTime;
    private Date endTime;
    private int lateTime;
    private String address;
    private int compereId;
    private int recorderId;
    private String content;
    private int auditId;
    private String summarize;
    private String file;
    private String meetingOrCourse;
    private int typeId;
}
