package cn.bdqn.dao.mapper;

import cn.bdqn.beans.bean.TopicType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TopicTypeMapper {
    List<TopicType> topicTypes();
}
