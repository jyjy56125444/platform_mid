package com.platform.mid.service.impl;

import com.platform.mid.dao.MidAppDao;
import com.platform.mid.entity.MidAppModel;
import com.platform.mid.service.MidAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/14
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.service.impl
 */
@Service("midAppService")
public class MidAppServiceImpl implements MidAppService {
    @Autowired
    private MidAppDao appDao;

    @Override
    public List<MidAppModel> queryList(Map<String, Object> map) {
        return appDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return appDao.queryTotal(map);
    }

    @Override
    public MidAppModel queryObject(String id) {
        return appDao.queryObject(id);
    }

    @Override
    public MidAppModel queryObjectByName(String name) {
        return appDao.queryObjectByName(name);
    }

    @Override
    public int update(MidAppModel user) {
        return appDao.update(user);
    }

    @Override
    public int save(MidAppModel user) {
        return appDao.save(user);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return appDao.deleteBatch(ids);
    }

    @Override
    public List<MidAppModel> queryListAll(Map<String, Object> map) {
        return appDao.queryListAll(map);
    }

    @Override
    public List<MidAppModel> queryListByUser(Map<String, Object> map) {
        return appDao.queryListByUser(map);
    }
}
