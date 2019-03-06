package com.platform.entity;

import java.io.Serializable;

/**
 * 作者： 王一凡
 * 创建时间： 2019/3/1
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.entity
 */
public class MidUrlVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private int appId;
    private String appUrlTest;
    private String appUrlFormat;
    private int appUrlType;
    private int appUrlStatus;

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
}
