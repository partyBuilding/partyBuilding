package cn.bdqn.biz.Service.impl;

import cn.bdqn.beans.pojo.MeetingManagement;
import cn.bdqn.biz.Service.MeetingManagementService;
import cn.bdqn.dao.mapper.MeetingManagementMapper;
import org.springframework.stereotype.Service;

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
}
