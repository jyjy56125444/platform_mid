package com.platform.service;

import com.platform.dao.ApiMidVersionMapper;
import com.platform.entity.MidVersionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 作者： 王一凡
 * 创建时间： 2019/3/1
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.service
 */
@Service
public class ApiMidVersionService {
    @Autowired
    private ApiMidVersionMapper versionDao;

    public MidVersionVo queryObject(Map<String, Object> map) {
        return versionDao.queryObject(map);
    }
}
