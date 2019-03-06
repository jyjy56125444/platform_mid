package com.platform.mid.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者： 王一凡
 * 创建时间： 2019/1/22
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.entity
 */
public class MidSysUserModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private int userGuid;

    private String userName;

    private String userPwd;

    private int userLev;

    private Date createTime;

    private String userEMail;

    private String userMobile;

    private int userStatus;

    public int getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(int userGuid) {
        this.userGuid = userGuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonIgnore
    public String getUserPwd() {
        return userPwd;
    }

    @JsonProperty
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public int getUserLev() {
        return userLev;
    }

    public void setUserLev(int userLev) {
        this.userLev = userLev;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserEMail() {
        return userEMail;
    }

    public void setUserEMail(String userEMail) {
        this.userEMail = userEMail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }
}
