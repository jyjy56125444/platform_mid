package com.platform.mid.service;

import com.platform.mid.entity.MidAppModel;
import com.platform.mid.entity.MidAppVersionModel;

import java.util.List;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/19
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.service
 */
public interface MidAppVersionService {
    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    List<MidAppVersionModel> queryObject(String id);

    /**
     * 保存实体
     *
     * @param version 实体
     * @return 保存条数
     */
    int save(MidAppVersionModel version);

    /**
     * 根据主键更新实体
     *
     * @param user 实体
     * @return 更新条数
     */
    int update(MidAppVersionModel user);
}
