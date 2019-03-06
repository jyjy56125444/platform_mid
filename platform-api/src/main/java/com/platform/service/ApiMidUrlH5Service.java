package com.platform.service;

import com.platform.dao.ApiMidUrlH5Mapper;
import com.platform.entity.MidUrlH5Vo;
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
public class ApiMidUrlH5Service {
    @Autowired
    private ApiMidUrlH5Mapper urlH5Dao;

    public MidUrlH5Vo queryObject(Map<String, Object> map) {
        return urlH5Dao.queryObject(map);
    }
}
