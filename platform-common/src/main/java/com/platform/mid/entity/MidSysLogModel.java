package com.platform.mid.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者： 王一凡
 * 创建时间： 2019/1/21
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.entity
 */
public class MidSysLogModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long rowguid;

    private int userGuid;

    private String userName;

    private String operate;

    private String userIP;

    private Date updateTime;

    private Date createTime;

    public Long getRowguid() {
        return rowguid;
    }

    public void setRowguid(Long rowguid) {
        this.rowguid = rowguid;
    }

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

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
