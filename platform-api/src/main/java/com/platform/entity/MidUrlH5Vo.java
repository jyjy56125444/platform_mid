package com.platform.entity;

import java.io.Serializable;

/**
 * 作者： 王一凡
 * 创建时间： 2019/3/1
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.entity
 */
public class MidUrlH5Vo implements Serializable {
    private static final long serialVersionUID = 1L;

    private int appId;
    private String appH5UrlTest;
    private String appH5UrlFormat;
    private int appH5UrlType;
    private int appH5UrlStatus;

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
}
