package cn.bdqn.biz.Service;

import cn.bdqn.beans.bean.Audit;

import java.util.List;

public interface AuditService {
    /**
     * 查询审核分类表
     * @return
     */
    List<Audit> audits();
}
