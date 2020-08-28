package cn.bdqn.biz.Service;

import cn.bdqn.beans.bean.TopicType;
import cn.bdqn.dao.mapper.TopicTypeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TopicTypeServiceImple implements TopicTypeService{

    @Resource
    private TopicTypeMapper topicTypeMapper;
    @Override
    public List<TopicType> topicTypes() {
        return topicTypeMapper.topicTypes();
    }
}
