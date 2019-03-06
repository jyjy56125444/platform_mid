package com.platform.mid.service;

import com.platform.mid.entity.MidAppUrlModel;
import com.platform.mid.entity.MidAppVersionModel;

import java.util.List;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/20
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.service
 */
public interface MidAppUrlService {
    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    MidAppUrlModel queryObject(String id);

    /**
     * 保存实体
     *
     * @param url 实体
     * @return 保存条数
     */
    int save(MidAppUrlModel url);

    /**
     * 根据主键更新实体
     *
     * @param url 实体
     * @return 更新条数
     */
    int update(MidAppUrlModel url);

    /**
     * 根据主键批量删除
     *
     * @param ids
     * @return 删除条数
     */
    int deleteBatch(Integer[] ids);
}
