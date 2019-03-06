package com.platform.mid.service.impl;

import com.platform.mid.dao.MidAppDownloadDao;
import com.platform.mid.entity.MidAppDownloadModel;
import com.platform.mid.service.MidAppDownloadService;
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
@Service("midAppDownloadService")
public class MidAppDownloadServiceImpl implements MidAppDownloadService {
    @Autowired
    private MidAppDownloadDao midAppDownloadDao;

    @Override
    public List<MidAppDownloadModel> queryList(Map<String, Object> map) {
        List<MidAppDownloadModel> list = midAppDownloadDao.queryList(map);
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return midAppDownloadDao.queryTotal(map);
    }
}
