package com.platform.mid.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/20
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.entity
 */
public class MidAppH5UrlModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private int appId;
    private String appH5UrlTest;
    private String appH5UrlFormat;
    private int appH5UrlType;
    private int appH5UrlStatus;

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

    public String getAppH5UrlTest() {
        return appH5UrlTest;
    }

    public void setAppH5UrlTest(String appH5UrlTest) {
        this.appH5UrlTest = appH5UrlTest;
    }

    public String getAppH5UrlFormat() {
        return appH5UrlFormat;
    }

    public void setAppH5UrlFormat(String appH5UrlFormat) {
        this.appH5UrlFormat = appH5UrlFormat;
    }

    public int getAppH5UrlType() {
        return appH5UrlType;
    }

    public void setAppH5UrlType(int appH5UrlType) {
        this.appH5UrlType = appH5UrlType;
    }

    public int getAppH5UrlStatus() {
        return appH5UrlStatus;
    }

    public void setAppH5UrlStatus(int appH5UrlStatus) {
        this.appH5UrlStatus = appH5UrlStatus;
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
}
