package com.platform.mid.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/20
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.entity
 */
public class MidAppUrlModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private int appId;
    private String appUrlTest;
    private String appUrlFormat;
    private int appUrlType;
    private int appUrlStatus;

    private String appName;
    private String interfaceDeveloper;
    private int appType;
    private String appTypeName;

    private Date createTime;
    private Date updateTime;
    private String creator;
    private String updater;

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getAppUrlTest() {
        return appUrlTest;
    }

    public void setAppUrlTest(String appUrlTest) {
        this.appUrlTest = appUrlTest;
    }

    public String getAppUrlFormat() {
        return appUrlFormat;
    }

    public void setAppUrlFormat(String appUrlFormat) {
        this.appUrlFormat = appUrlFormat;
    }

    public int getAppUrlType() {
        return appUrlType;
    }

    public void setAppUrlType(int appUrlType) {
        this.appUrlType = appUrlType;
    }

    public int getAppUrlStatus() {
        return appUrlStatus;
    }

    public void setAppUrlStatus(int appUrlStatus) {
        this.appUrlStatus = appUrlStatus;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getInterfaceDeveloper() {
        return interfaceDeveloper;
    }

    public void setInterfaceDeveloper(String interfaceDeveloper) {
        this.interfaceDeveloper = interfaceDeveloper;
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

    public int getAppType() {
        return appType;
    }

    public void setAppType(int appType) {
        this.appType = appType;
    }

    public String getAppTypeName() {
        return appTypeName;
    }

    public void setAppTypeName(String appTypeName) {
        this.appTypeName = appTypeName;
    }
}
