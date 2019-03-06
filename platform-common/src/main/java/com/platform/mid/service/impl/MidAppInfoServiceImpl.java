package com.platform.mid.service.impl;

import com.platform.mid.dao.MidAppInfoDao;
import com.platform.mid.entity.MidAppBaseModel;
import com.platform.mid.entity.MidAppInfoModel;
import com.platform.mid.service.MidAppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/18
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.service.impl
 */
@Service("midAppInfoService")
public class MidAppInfoServiceImpl implements MidAppInfoService {
    @Autowired
    private MidAppInfoDao appInfoDao;

    @Override
    public List<MidAppInfoModel> queryList(Map<String, Object> map) {
        return appInfoDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return appInfoDao.queryTotal(map);
    }

    @Override
    public MidAppInfoModel queryObject(String id) {
        return appInfoDao.queryObject(id);
    }

    @Override
    public int update(MidAppInfoModel user) {
        return appInfoDao.update(user);
    }

    @Override
    public int save(MidAppInfoModel user) {
        return appInfoDao.save(user);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return appInfoDao.deleteBatch(ids);
    }

}
