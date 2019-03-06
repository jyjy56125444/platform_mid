package com.platform.entity;

import java.io.Serializable;

/**
 * 作者： 王一凡
 * 创建时间： 2019/3/1
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.entity
 */
public class AppInfoVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String appId;
    private String itUrl;
    private String h5Url;
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getItUrl() {
        return itUrl;
    }

    public void setItUrl(String itUrl) {
        this.itUrl = itUrl;
    }

    public String getH5Url() {
        return h5Url;
    }

    public void setH5Url(String h5Url) {
        this.h5Url = h5Url;
    }
}
