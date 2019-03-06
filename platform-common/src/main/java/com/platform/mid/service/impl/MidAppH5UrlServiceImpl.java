package com.platform.mid.service.impl;

import com.platform.mid.dao.MidAppH5UrlDao;
import com.platform.mid.entity.MidAppH5UrlModel;
import com.platform.mid.service.MidAppH5UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/20
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.service.impl
 */
@Service("midAppH5UrlService")
public class MidAppH5UrlServiceImpl implements MidAppH5UrlService {
    @Autowired
    private MidAppH5UrlDao appH5UrlDao;

    @Override
    public MidAppH5UrlModel queryObject(String id) {
        return appH5UrlDao.queryObject(id);
    }

    @Override
    public int save(MidAppH5UrlModel url) {
        return appH5UrlDao.save(url);
    }

    @Override
    public int update(MidAppH5UrlModel url) {
        return appH5UrlDao.update(url);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return appH5UrlDao.deleteBatch(ids);
    }
}
