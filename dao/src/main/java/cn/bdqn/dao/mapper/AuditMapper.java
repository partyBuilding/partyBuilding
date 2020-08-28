package cn.bdqn.dao.mapper;

import cn.bdqn.beans.bean.Audit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuditMapper {
    /**
     * 查询审核分类表
     * @return
     */
    List<Audit> audits();
}
