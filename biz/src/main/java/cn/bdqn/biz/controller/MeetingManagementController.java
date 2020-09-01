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
                                          @RequestParam(value = "id",defaultValue = "0") int id,
                                          @RequestParam(value = "meetingOrCourse",defaultValue = "0") int meetingOrCourse,
                                          @RequestParam(value = "status",defaultValue = "0") int status){
        PageHelper.startPage(start,size,"id desc");
        List<MeetingManagement> meetingManagementList = meetingManagementService.getMeetingManagement(title,typeId,auditId,id,meetingOrCourse);
        PageInfo<MeetingManagement> page = new PageInfo<>(meetingManagementList);
        return ResponseDataUtil.success("查询成功",page);
    }
    @RequiresRoles("ROLE_admin")
    @PostMapping(value = "/addMeetingManagement")
    public Object addMeetingManagement(MeetingManagement meetingManagement,
                                       @RequestParam(value = "uid") List<Integer> uid){
        try{
            meetingManagementService.addMeetingManagement(meetingManagement,uid);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDataUtil.failure("添加失败");
        }
        return ResponseDataUtil.success("添加成功");
    }
    @RequiresRoles("ROLE_admin")
    @PostMapping(value = "/updateMeetingManagementAuditById")
    public Object updateMeetingManagementAuditById(@RequestParam(value = "id",defaultValue = "0") int id,
                                                   @RequestParam(value = "auditId",defaultValue = "0") int auditId){
        if(meetingManagementService.updateMeetingManagementAuditById(id,auditId)>0){
            return ResponseDataUtil.success("修改成功");
        }else{
            return ResponseDataUtil.failure("修改失败");
        }
    }
    @RequiresRoles("ROLE_admin")
    @PostMapping(value = "/delMeetingmanagementById")
    public Object delMeetingmanagementById(@RequestParam(value = "id",defaultValue = "0") int id){
        try {
            meetingManagementService.delMeetingmanagementById(id);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDataUtil.failure("删除失败");
        }
        return ResponseDataUtil.success("删除成功");
    }
    @RequiresRoles("ROLE_admin")
    @PostMapping(value = "/addSummarizeById")
    public Object addSummarizeById(@RequestParam(value = "id",defaultValue = "0") int id,
                                   @RequestParam(value = "summarize") String summarize,
                                   @RequestParam(value = "summarizeFile") String summarizeFile){
        if(meetingManagementService.addSummarizeById(id,summarize,summarizeFile)>0){
            return ResponseDataUtil.success("添加总结成功");
        }else{
            return ResponseDataUtil.failure("添加总结失败");
        }

    }
}
