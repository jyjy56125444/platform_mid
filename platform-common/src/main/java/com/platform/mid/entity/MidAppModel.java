package com.platform.mid.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/14
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.entity
 */
public class MidAppModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private int appId;
    private String appName;
    private String appFullName;
    private String appIcon;
    private int appType;
    private Date createTime;
    private Date updateTime;
    private String creator;
    private String updater;

    private String type;

    private List<MidAppAuthModel> auth;

    public List<MidAppAuthModel> getAuth() {
        return auth;
    }

    public void setAuth(List<MidAppAuthModel> auth) {
        this.auth = auth;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppFullName() {
        return appFullName;
    }

    public void setAppFullName(String appFullName) {
        this.appFullName = appFullName;
    }

    public String getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(String appIcon) {
        this.appIcon = appIcon;
    }

    public int getAppType() {
        return appType;
    }

    public void setAppType(int appType) {
        this.appType = appType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
