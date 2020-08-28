package cn.bdqn.dao.mapper;

import cn.bdqn.beans.bean.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
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
    List<Comment> getCommentConditionPageAll(@Param("title") String title);
}
