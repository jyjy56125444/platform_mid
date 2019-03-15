package com.platform.mid.service.impl;

import com.platform.mid.dao.MidAppDao;
import com.platform.mid.dao.MidSysUserDao;
import com.platform.mid.entity.MidAppInfoModel;
import com.platform.mid.entity.MidAppModel;
import com.platform.mid.entity.MidSysUserModel;
import com.platform.mid.entity.MidSysUserPwdModel;
import com.platform.mid.service.MidAppService;
import com.platform.mid.service.MidSysUserService;
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
@Service("midSysUserService")
public class MidSysUserServiceImpl implements MidSysUserService {
    @Autowired
    private MidSysUserDao userDao;

    @Override
    public List<MidSysUserModel> queryList(Map<String, Object> map) {
        return userDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return userDao.queryTotal(map);
    }

    @Override
    public List<MidSysUserModel> queryListAll() {
        return userDao.queryListAll();
    }

    @Override
    public MidSysUserModel queryObject(String id) {
        return userDao.queryObject(id);
    }

    @Override
    public int update(MidSysUserModel user) {
        return userDao.update(user);
    }

    @Override
    public int save(MidSysUserModel user) {
        return userDao.save(user);
    }

    @Override
    public int updatePassword(MidSysUserPwdModel pwd) {
        return userDao.updatePassword(pwd);
    }
}
