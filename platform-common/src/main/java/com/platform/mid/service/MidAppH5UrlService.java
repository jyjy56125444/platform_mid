package com.platform.mid.service;

import com.platform.mid.entity.MidAppH5UrlModel;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/20
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.service
 */
public interface MidAppH5UrlService {
    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    MidAppH5UrlModel queryObject(String id);

    /**
     * 保存实体
     *
     * @param url 实体
     * @return 保存条数
     */
    int save(MidAppH5UrlModel url);

    /**
     * 根据主键更新实体
     *
     * @param url 实体
     * @return 更新条数
     */
    int update(MidAppH5UrlModel url);

    /**
     * 根据主键批量删除
     *
     * @param ids
     * @return 删除条数
     */
    int deleteBatch(Integer[] ids);
}
