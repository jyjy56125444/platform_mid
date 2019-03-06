package com.platform.mid.service.impl;

import com.platform.mid.dao.MidAppBaseDao;
import com.platform.mid.entity.MidAppBaseModel;
import com.platform.mid.service.MidAppBaseService;
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
@Service("midAppBaseService")
public class MidAppBaseServiceImpl implements MidAppBaseService {
    @Autowired
    private MidAppBaseDao appBaseDao;

    @Override
    public List<MidAppBaseModel> queryList(Map<String, Object> map) {
        return appBaseDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return appBaseDao.queryTotal(map);
    }

    @Override
    public MidAppBaseModel queryObject(String id) {
        return appBaseDao.queryObject(id);
    }

    @Override
    public int update(MidAppBaseModel user) {
        return appBaseDao.update(user);
    }

    @Override
    public int save(MidAppBaseModel user) {
        return appBaseDao.save(user);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return appBaseDao.deleteBatch(ids);
    }
}
