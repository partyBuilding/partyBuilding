package cn.bdqn.biz.controller;

import cn.bdqn.beans.bean.*;
import cn.bdqn.biz.Service.*;
import cn.bdqn.dao.mapper.SubjectMapper;
import cn.bdqn.util.util.ResponseDataUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/manage")
public class Contorller_M {

    @Resource
    private DocumentService documentService;

    @RequestMapping("/document")
    public Object document(Document document){
        List<Document> list =documentService.DocumentPageAll(document);
        return list;
    }

    @RequestMapping("/addDocument")
    public Object add(Document document){   //新增文档
        try{
            documentService.addDocument(document);
            return ResponseDataUtil.success("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDataUtil.failure("添加失败");
        }
    }

    @RequestMapping("/updateDocument")
    public Object update(Document document){   //更新文档
        try{
            documentService.updateDocument(document);
            return ResponseDataUtil.success("更新成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDataUtil.failure("更新失败");
        }
    }

    @RequestMapping("/delDocument")
    public Object del(Integer id){
        try{
            documentService.delDocument(id);
            return ResponseDataUtil.success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDataUtil.failure("删除失败");
        }
    }

    @RequestMapping("/queryDocument")
    public Object query(Document document, @RequestParam(value="start",defaultValue = "0") Integer start,
                        @RequestParam(value = "size",defaultValue = "5") Integer size){
        PageHelper.startPage(start,size,"id desc");
        List<Document> list = documentService.DocumentPageAll(document);
        PageInfo<Document> pageInfo = new PageInfo<>(list);
        return ResponseDataUtil.success("查询成功",pageInfo);
    }


    @RequestMapping("/queryDocumentDetails")
    public Object queryDetails(@RequestParam("id")Integer id){  //查看文档详情
        return ResponseDataUtil.success("",documentService.getDocumentDetails(id));
    }


    @Resource
    private CommentService commentService;
    @RequestMapping("/delComment")
    public Object delComment(@RequestParam("id")Integer id){   //删除评论
        try{
            commentService.delComment(id);
            return  ResponseDataUtil.success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDataUtil.failure("删除失败");
        }
    }

    @RequestMapping("/commentPageAll")
    public Object getCommentPageAll(@RequestParam("title")String title
            , @RequestParam(value="start",defaultValue = "0")Integer start
            ,@RequestParam(value="size",defaultValue = "5") Integer size){   //按条件查询全部
        PageHelper.startPage(start,size,"id desc");
        PageInfo pageInfo = new PageInfo(commentService.getCommentConditionPageAll(title));
        return ResponseDataUtil.success("",pageInfo);
    }

    @Resource
    private TypeService typeService;

    @RequestMapping("/getTypes")
    public Object Types(){   //获取文档表 全部分类的接口
       return ResponseDataUtil.success("", typeService.types());
    }

    @Resource
    private AuditService auditService;
    @RequestMapping("/getAudits")
    public Object audit(){    //获取审核表全部信息
        return ResponseDataUtil.success("",auditService.audits());
    }


    @Resource
    private SubjectService subjectService;
    @Resource
    private OptionsService optionsService;

    @RequestMapping("/addSubject")
    public Object addSubject(@RequestBody Subject subject){   //新增考试题目
        try {
            System.out.println(subject.toString());
            subjectService.addSubject(subject);  //插入题目实体并返回自增id
            for (Options op : subject.getOptions()) {   //遍历传入的答案选项
                op.setSubjectId(subject.getId());  //将题目实体的id赋值给选项实体关联起来
                optionsService.addOption(op);    //添加选项实体
            }
            return ResponseDataUtil.success("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDataUtil.failure("添加失败");
        }
    }

    @RequestMapping("/delSubject")
    public Object delSubject(@RequestParam("id")int id){  //删除题目
        try{
            subjectService.del(id);
            return  ResponseDataUtil.success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDataUtil.failure("删除失败");
        }
    }

    @RequestMapping("/updateSubject")
    public Object updateSubject(Subject subject){   //修改题目信息 包括更改审核状态
        try{
            subjectService.update(subject);
            return  ResponseDataUtil.success("更新成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDataUtil.failure("更新失败");
        }
    }

    @RequestMapping("/selectSubject")
    public Object SelectSubejct(Subject subject,
                                @RequestParam(value="start",defaultValue = "0")Integer start,
                                @RequestParam(value="size",defaultValue = "5")Integer size){  //查询题目列表并分页

        PageHelper.startPage(start,size,"id desc");
        subjectService.select(subject);
        PageInfo<Subject> page = new PageInfo<>();
        return ResponseDataUtil.success("",page);
    }

    @Resource
    private TopicTypeService topicTypeService;

    @RequestMapping("/selectTopicType")
    public Object topicTypes(){  //查询所有题型分类表
        return ResponseDataUtil.success("",topicTypeService.topicTypes());
    }

    @Resource
    private ExamService examService;
    @Resource
    private ExamTopicsService examTopicsService;
    @RequestMapping("/addExamOrQuestionnaire")
    public Object addExamOrQuestionnaire(@RequestBody Exam exam){   //新增考试 OR 调查问卷
        try {
            System.out.println(exam.toString());
            examService.addExam(exam);
            System.out.println(exam.getId());
            for (ExamTopics examTopics : exam.getExamTopics()) {
                examTopics.setEaxmId(exam.getId());   //获取新增考试 自增id
                examTopicsService.addExamTopics(examTopics); //新增考试与题目关联实体
            }
            return ResponseDataUtil.success("新增成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDataUtil.success("新增失败");
        }
    }


    @RequestMapping("/updateExamOrQuestionnaire")
    public Object updateExam(Exam exam){   //修改考试信息 包括审核 OR 调查问卷
        try{
            examService.updateExam(exam);
            return  ResponseDataUtil.success("更新成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDataUtil.failure("更新失败");
        }
    }

    @RequestMapping("/delExamOrQuestionnaire")
    public Object delExamOrQuestionnaire(@RequestParam("id")int id){   //删除考试或调查问卷实体
        try{
            examService.delExam(id);
            return  ResponseDataUtil.success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDataUtil.failure("删除失败");
        }
    }

    @RequestMapping("/queryExamPage")
    public Object queryExam(Exam exam,
                            @RequestParam(value="start",defaultValue = "0")Integer start,
                            @RequestParam(value="start",defaultValue = "5")Integer size){ //条件查询考试表 并分页
        PageHelper.startPage(start,size,"id desc");
        PageInfo<Exam> pageInfo = new PageInfo<>(examService.queryExam(exam));
        return ResponseDataUtil.success("",pageInfo);
    }

    @RequestMapping("/addQuestionnaire")
    public Object addQuestionnaire(@RequestBody Exam exam){   //添加调查问卷
        try {
            examService.addExam(exam);
            for (Subject subject : exam.getSubjects()) {
                subjectService.addSubject(subject);     //添加题目
                for (Options options : subject.getOptions()) {  //每到题下多个选项
                    options.setSubjectId(subject.getId());  //确定选项属于哪道题
                    optionsService.addOption(options);    //新增选项
                }
                ExamTopics examTopics = new ExamTopics();
                examTopics.setEaxmId(exam.getId());
                examTopics.setSubjectId(subject.getId());
                examTopicsService.addExamTopics(examTopics);   //添加调查问卷 与 题目之间的关联实体
            }
            return ResponseDataUtil.success("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDataUtil.failure("添加失败");
        }
    }


    @RequestMapping("/getDetails")
    public Object getDetails(@RequestParam("id") int id){  //获取考试 或者 调查问卷的题目列表详情
        return examTopicsService.getDetails(id);
    }

    @RequestMapping("/updateOptions")
    public Object updateOptions(Options options){  //修改题目选项信息
        try{
            optionsService.updateOption(options);
            return  ResponseDataUtil.success("更新成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDataUtil.failure("更新失败");
        }
    }
}
