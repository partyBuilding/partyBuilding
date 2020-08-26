package cn.bdqn.biz.controller;

import cn.bdqn.beans.pojo.MeetingManagement;
import cn.bdqn.biz.Service.MeetingManagementService;
import cn.bdqn.util.util.ResponseDataUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MeetingManagementController {
    @Resource
    private MeetingManagementService meetingManagementService;
    @PostMapping(value = "/getMeetingManagement")
    @RequiresRoles("ROLE_admin")
    public Object getMeetingManagement(@RequestParam(value = "start",defaultValue = "0") int start,
                                          @RequestParam(value = "size",defaultValue = "1") int size,
                                          @RequestParam(value = "title",required = false) String title,
                                          @RequestParam(value = "typeId",defaultValue = "0") int typeId,
                                          @RequestParam(value = "auditId",defaultValue = "0") int auditId,
                                          @RequestParam(value = "id",defaultValue = "0") int id){
        PageHelper.startPage(start,size,"id desc");
        List<MeetingManagement> meetingManagementList = meetingManagementService.getMeetingManagement(title,typeId,auditId,id);
        PageInfo<MeetingManagement> page = new PageInfo<>(meetingManagementList);
        return ResponseDataUtil.success("查询成功",page);
    }
    @RequiresRoles("ROLE_admin")
    @PostMapping(value = "/addMeetingManagement")
    public Object addMeetingManagement(MeetingManagement meetingManagement,
                                       @RequestParam(value = "uid") List<Integer> uid){
        System.out.println(uid);
        try{
            meetingManagementService.addMeetingManagement(meetingManagement,uid);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDataUtil.failure("添加失败");
        }
        return ResponseDataUtil.success("添加成功");
    }
}
