package com.platform.mid.service;

import com.platform.mid.entity.MidAppAuthModel;
import com.platform.mid.entity.MidAppBaseModel;

import java.util.List;
import java.util.Map;

/**
 * 作者： 王一凡
 * 创建时间： 2019/3/8
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.service
 */
public interface MidAppAuthService {
    /**
     * 保存实体
     * @return 保存条数
     */
    void save(Map<String, Object> map);

    /**
     * 根据主键批量删除
     *
     * @param ids
     * @return 删除条数
     */
    int deleteBatch(Integer[] ids);

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    List<MidAppAuthModel> queryObjectDataList(String id);
}
