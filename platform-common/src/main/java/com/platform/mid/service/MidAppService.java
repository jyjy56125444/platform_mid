package com.platform.mid.service;

import com.platform.mid.entity.MidAppModel;

import java.util.List;
import java.util.Map;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/14
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.service
 */
public interface MidAppService {
    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<MidAppModel> queryList(Map<String, Object> map);

    /**
     * 全部查询
     *
     * @return list
     */
    List<MidAppModel> queryListAll(Map<String, Object> map);

    /**
     * 分页统计总数
     *
     * @param map 参数
     * @return 总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    MidAppModel queryObject(String id);

    /**
     * 根据名称查询实体
     *
     * @param nmae 名称
     * @return 实体
     */
    MidAppModel queryObjectByName(String nmae);

    /**
     * 根据主键更新实体
     *
     * @param user 实体
     * @return 更新条数
     */
    int update(MidAppModel user);

    /**
     * 保存实体
     *
     * @param user 实体
     * @return 保存条数
     */
    int save(MidAppModel user);

    /**
     * 根据主键批量删除
     *
     * @param ids
     * @return 删除条数
     */
    int deleteBatch(Integer[] ids);
}
