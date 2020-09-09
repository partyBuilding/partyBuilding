package cn.bdqn.biz.Service.impl;

import cn.bdqn.beans.bean.Comment;
import cn.bdqn.biz.Service.CommentService;
import cn.bdqn.dao.mapper.CommentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Transactional
    @Override
    public boolean delComment(int id) {
        return commentMapper.delComment(id);
    }

    @Override
    public List<Comment> getCommentConditionPageAll(String title) {
        return commentMapper.getCommentConditionPageAll(title);
    }
}
