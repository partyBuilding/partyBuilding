package cn.bdqn.biz.Service;

import cn.bdqn.beans.bean.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {
    /**
     * 删除评论
     * @param id
     * @return
     */
    boolean delComment(@Param("id")int id);

    /**
     * 获取全部文档评论 或按文档查询评论
     * @return
     */
    List<Comment> getCommentConditionPageAll(String title);
}
