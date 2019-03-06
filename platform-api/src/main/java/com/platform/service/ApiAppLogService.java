package com.platform.service;

import com.platform.dao.ApiAppLogMapper;
import com.platform.entity.AppLogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者： 王一凡
 * 创建时间： 2019/3/1
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.service
 */
@Service
public class ApiAppLogService {
    @Autowired
    private ApiAppLogMapper logDao;

    public int save(AppLogVo log) {
        return logDao.save(log);
    }
}
