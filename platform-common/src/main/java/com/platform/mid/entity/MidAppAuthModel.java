package com.platform.mid.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 作者： 王一凡
 * 创建时间： 2019/3/8
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.entity
 */
public class MidAppAuthModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private int userGuid;
    private int appId;
    private int authLev;

    public int getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(int userGuid) {
        this.userGuid = userGuid;
    }

    @JsonIgnore
    public int getAppId() {
        return appId;
    }

    @JsonProperty
    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getAuthLev() {
        return authLev;
    }

    public void setAuthLev(int authLev) {
        this.authLev = authLev;
    }
}
