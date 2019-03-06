package com.platform.mid.service;

import com.platform.mid.entity.MidAppInfoModel;
import com.platform.mid.entity.MidAppModel;
import com.platform.mid.entity.MidSysUserModel;
import com.platform.mid.entity.MidSysUserPwdModel;

import java.util.List;
import java.util.Map;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/21
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.service
 */
public interface MidSysUserService {
    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<MidSysUserModel> queryList(Map<String, Object> map);

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
    MidSysUserModel queryObject(String id);

    /**
     * 根据主键更新实体
     *
     * @param user 实体
     * @return 更新条数
     */
    int update(MidSysUserModel user);

    /**
     * 保存实体
     *
     * @param user 实体
     * @return 保存条数
     */
    int save(MidSysUserModel user);

    /**
     * 修改密码
     */
    int updatePassword(MidSysUserPwdModel pwd);
}
