package com.platform.mid.service;

import com.platform.entity.SysLogEntity;
import com.platform.mid.entity.MidSysLogModel;

import java.util.List;
import java.util.Map;

/**
 * 作者： 王一凡
 * 创建时间： 2019/1/21
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.service
 */
public interface MidSysLogService {
    MidSysLogModel queryObject(Long id);

    List<MidSysLogModel> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(MidSysLogModel sysLog);

    void update(MidSysLogModel sysLog);

    void delete(Long id);

    void deleteBatch(Long[] ids);
}
