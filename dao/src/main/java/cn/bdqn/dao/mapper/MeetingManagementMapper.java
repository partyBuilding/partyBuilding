package cn.bdqn.dao.mapper;

import cn.bdqn.beans.pojo.MeetingManagement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MeetingManagementMapper {
    //根据可选条件查询会议列表
    List<MeetingManagement> getMeetingManagement(@Param("title") String title,@Param("typeId") int typeId,@Param("auditId") int auditId,@Param("id") int id,@Param("meetingOrCourse") int meetingOrCourse);
    //新增会议
    int addMeetingManagement(MeetingManagement meetingManagement);
    //新增的会议必须有参与人员，给新增的会议添加参与人员
    int addJoinStaff(int uid,int meetingManagementId);
    //根据会议id修改审核状态
    int updateMeetingManagementAuditById(@Param("id") int id,@Param("auditId") int auditId);
    //根据会议id删除会议
    int delMeetingmanagementById(@Param("id") int id);
    //删除会议后必须删除参加此会议人员的记录，删除指定会议的参与人员
    int delJoinStaffByMid(@Param("mid") int mid);
    //给指定会议添加总结
    int addSummarizeById(@Param("id") int id,@Param("summarize") String summarize,@Param("summarizeFile")String summarizeFile);
    //查询指定会议的参与人员Id
    List<Integer> getUidByMeetingManagementId(@Param("mid") int mid);
}
