package com.platform.mid.entity;

import java.io.Serializable;

/**
 * 作者： 王一凡
 * 创建时间： 2019/3/6
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.entity
 */
public class MidSysUserPwdModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private int userId;
    private String password;
    private String newPassword;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
