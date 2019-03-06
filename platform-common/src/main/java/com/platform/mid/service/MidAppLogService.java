package com.platform.mid.service;

import com.platform.mid.entity.MidAppLogModel;

import java.util.List;
import java.util.Map;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/21
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.service
 */
public interface MidAppLogService {
    List<MidAppLogModel> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);
}
