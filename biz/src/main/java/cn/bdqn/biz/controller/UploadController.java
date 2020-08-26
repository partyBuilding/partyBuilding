package cn.bdqn.biz.controller;

import cn.bdqn.util.util.ResponseDataUtil;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class UploadController {
    @RequiresRoles("ROLE_admin")
    @PostMapping(value = "/uploadFile")
    public Object uploadFile(MultipartFile uploadFile , HttpServletRequest req){
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy/MM/dd");
        String realPath = req.getSession().getServletContext().getRealPath("/uploadFile/");
        String format = sdf.format(new Date());
        File folder = new File(realPath + format);
        if(!folder.isDirectory()){
            folder.mkdirs();
        }
        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."),oldName.length());
        try {
            uploadFile.transferTo(new File(folder,newName));
            String filePath = req.getScheme()+ "://" + req.getServerName() + ":" +
                    req.getServerPort () + "/uploadFile/ " + format + newName ;
            return ResponseDataUtil.success("上传成功",filePath);
        }catch (Exception e){
            return ResponseDataUtil.failure("上传失败");
        }
    }
}
