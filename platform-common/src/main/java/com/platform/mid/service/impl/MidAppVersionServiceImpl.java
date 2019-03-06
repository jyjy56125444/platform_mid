package com.platform.mid.service.impl;

import com.platform.mid.dao.MidAppVersionDao;
import com.platform.mid.entity.MidAppModel;
import com.platform.mid.entity.MidAppVersionModel;
import com.platform.mid.service.MidAppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/19
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.service.impl
 */
@Service("midAppVersionService")
public class MidAppVersionServiceImpl implements MidAppVersionService {
    @Autowired
    private MidAppVersionDao appVersionDao;

    @Override
    public List<MidAppVersionModel> queryObject(String id) {
        return appVersionDao.queryObjectDataList(id);
    }

    @Override
    public int save(MidAppVersionModel version) {
        return appVersionDao.save(version);
    }

    @Override
    public int update(MidAppVersionModel user) {
        return appVersionDao.update(user);
    }
}
