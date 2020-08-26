package cn.bdqn.dao.mapper;

import cn.bdqn.beans.pojo.MeetingManagement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MeetingManagementMapper {
    //根据可选条件查询会议列表
    List<MeetingManagement> getMeetingManagement(@Param("title") String title,@Param("typeId") int typeId,@Param("auditId") int auditId,@Param("id") int id);
    //新增会议
    int addMeetingManagement(MeetingManagement meetingManagement);
    //给新增的会议添加参与人员
    int addJoinStaff(int uid,int meetingManagementId);
}
