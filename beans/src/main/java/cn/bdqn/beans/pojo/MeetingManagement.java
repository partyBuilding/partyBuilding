package cn.bdqn.beans.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class MeetingManagement {
    private int id;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
