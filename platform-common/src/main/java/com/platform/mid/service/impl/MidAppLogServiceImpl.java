package com.platform.mid.service.impl;

import com.platform.mid.dao.MidAppLogDao;
import com.platform.mid.dao.MidSysLogDao;
import com.platform.mid.entity.MidAppLogModel;
import com.platform.mid.entity.MidSysLogModel;
import com.platform.mid.service.MidAppLogService;
import com.platform.mid.service.MidSysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/21
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.service.impl
 */
@Service("midAppLogService")
public class MidAppLogServiceImpl implements MidAppLogService {
    @Autowired
    private MidAppLogDao midAppLogDao;

    @Override
    public List<MidAppLogModel> queryList(Map<String, Object> map) {
        List<MidAppLogModel> list = midAppLogDao.queryList(map);
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return midAppLogDao.queryTotal(map);
    }
}
