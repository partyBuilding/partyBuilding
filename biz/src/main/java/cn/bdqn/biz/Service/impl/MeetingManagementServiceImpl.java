package cn.bdqn.biz.Service.impl;

import cn.bdqn.beans.pojo.MeetingManagement;
import cn.bdqn.biz.Service.MeetingManagementService;
import cn.bdqn.dao.mapper.MeetingManagementMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class MeetingManagementServiceImpl implements MeetingManagementService {
    @Resource
    private MeetingManagementMapper meetingManagementMapper;

    @Override
    public List<MeetingManagement> getMeetingManagement(String title,int typeId,int auditId,int id) {
        return meetingManagementMapper.getMeetingManagement(title,typeId,auditId,id);
    }
    @Transactional
    @Override
    public void addMeetingManagement(MeetingManagement meetingManagement, List<Integer> uid) {
        if(meetingManagementMapper.addMeetingManagement(meetingManagement)>0){
            int id = meetingManagement.getId();
            for (int i=0;i<uid.size();i++){
                meetingManagementMapper.addJoinStaff(uid.get(i),id);
            }
        }
    }
}
