package cn.bdqn.biz.Service.impl;

import cn.bdqn.beans.bean.Options;
import cn.bdqn.biz.Service.OptionsService;
import cn.bdqn.dao.mapper.OptionsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class OptionsServiceImpl implements OptionsService {
    @Resource
    private OptionsMapper optionsMapper;

    @Override
    public void addOption(Options options) {
        optionsMapper.addOption(options);
    }

    @Override
    public boolean updateOption(Options options) {
        return optionsMapper.updateOption(options);
    }
}
