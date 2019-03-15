package com.platform.mid.service.impl;

import com.platform.mid.dao.MidAppAuthDao;
import com.platform.mid.entity.MidAppAuthModel;
import com.platform.mid.entity.MidAppBaseModel;
import com.platform.mid.service.MidAppAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 作者： 王一凡
 * 创建时间： 2019/3/8
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.service.impl
 */
@Service("midAppAuthService")
public class MidAppAuthServiceImpl implements MidAppAuthService {
    @Autowired
    private MidAppAuthDao appAuthDao;

    @Override
    public void save(Map<String, Object> map) {
        appAuthDao.save(map);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return appAuthDao.deleteBatch(ids);
    }

    @Override
    public List<MidAppAuthModel> queryObjectDataList(String id) {
        return appAuthDao.queryObjectDataList(id);
    }
}
