package cn.bdqn.biz.Service;

import cn.bdqn.beans.pojo.MeetingManagement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MeetingManagementService {
    List<MeetingManagement> getMeetingManagement(String title,int typeId,int auditId,int id);
}
