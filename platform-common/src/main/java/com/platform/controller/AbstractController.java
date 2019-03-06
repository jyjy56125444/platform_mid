package com.platform.controller;

import com.platform.entity.SysUserEntity;
import com.platform.mid.entity.MidSysUserModel;
import com.platform.utils.ShiroUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller公共组件
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2016年11月9日 下午9:42:26
 */
public abstract class AbstractController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected MidSysUserModel getUser() {
        return ShiroUtils.getUserEntity();
    }

    protected int getUserId() {
        return getUser().getUserGuid();
    }

}
