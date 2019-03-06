package com.platform.mid.dao;

import com.platform.dao.BaseDao;
import com.platform.entity.SysMenuEntity;

import java.util.List;

/**
 * 作者： 王一凡
 * 创建时间： 2019/1/22
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.dao
 */
public interface MidSysMenuDao  extends BaseDao<SysMenuEntity> {
    /**
     * 根据父菜单，查询子菜单
     *
     * @param parentId 父菜单ID
     */
    List<SysMenuEntity> queryListParentId(Long parentId);

    /**
     * 获取不包含按钮的菜单列表
     */
    List<SysMenuEntity> queryNotButtonList();

    /**
     * 查询用户的权限列表
     */
    List<SysMenuEntity> queryUserList(Long userId);
}
