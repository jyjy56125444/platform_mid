package com.platform.mid.service.impl;

import com.platform.mid.dao.MidAppUrlDao;
import com.platform.mid.entity.MidAppUrlModel;
import com.platform.mid.entity.MidAppVersionModel;
import com.platform.mid.service.MidAppUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/20
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.service.impl
 */
@Service("midAppUrlService")
public class MidAppUrlServiceImpl implements MidAppUrlService {
    @Autowired
    private MidAppUrlDao appUrlDao;

    @Override
    public MidAppUrlModel queryObject(String id) {
        return appUrlDao.queryObject(id);
    }

    @Override
    public int save(MidAppUrlModel url) {
        return appUrlDao.save(url);
    }

    @Override
    public int update(MidAppUrlModel url) {
        return appUrlDao.update(url);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return appUrlDao.deleteBatch(ids);
    }
}
