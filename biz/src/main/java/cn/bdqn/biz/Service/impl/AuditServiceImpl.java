package cn.bdqn.biz.Service.impl;

import cn.bdqn.beans.bean.Audit;
import cn.bdqn.biz.Service.AuditService;
import cn.bdqn.dao.mapper.AuditMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AuditServiceImpl implements AuditService {
    @Resource
    private AuditMapper auditMapper;

    @Override
    public List<Audit> audits() {
        return auditMapper.audits();
    }
}
