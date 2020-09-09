package cn.bdqn.beans.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Document {
    private int id;
    private String title;
    private int typeId;
    private String typeName;
    private String publisher;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseTime;
    private int auditId;
    private int commentNum;
    private String pageView;
    private int likenum;
    private int documentCommentId;
    private String images;
    private String accessory;
    private int commentSum;
    private String content;
    private String oldImages;
    private String oldAccessory;

}
