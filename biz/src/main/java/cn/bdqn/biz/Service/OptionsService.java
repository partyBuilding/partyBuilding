package cn.bdqn.biz.Service;

import cn.bdqn.beans.bean.Options;
import org.apache.ibatis.annotations.Param;

public interface OptionsService {
    /**
     * 新增题目的答案选项
     */
    void addOption(Options options);

    /**
     * 修改题目选项
     * @param options
     * @return
     */
    boolean updateOption(Options options);
}
