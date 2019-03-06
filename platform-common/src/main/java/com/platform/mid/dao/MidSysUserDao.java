package com.platform.mid.dao;

import com.platform.dao.BaseDao;
import com.platform.entity.UserWindowDto;
import com.platform.mid.entity.MidSysUserModel;
import com.platform.mid.entity.MidSysUserPwdModel;

import java.util.List;
import java.util.Map;

/**
 * 作者： 王一凡
 * 创建时间： 2019/1/22
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.dao
 */
public interface MidSysUserDao extends BaseDao<MidSysUserModel> {
    /**
     * 查询用户的所有权限
     *
     * @param userId 用户ID
     */
    List<String> queryAllPerms(Long userId);

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     * 根据用户名，查询系统用户
     */
    MidSysUserModel queryByUserName(String username);

    /**
     * 修改密码
     */
    int updatePassword(MidSysUserPwdModel pwd);
    /**
     * 根据实体类查询
     * @param userWindowDto
     * @return
     */
    List<UserWindowDto> queryListByBean(UserWindowDto userWindowDto);
}
