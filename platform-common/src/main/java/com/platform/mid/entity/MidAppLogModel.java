package com.platform.mid.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/21
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.entity
 */
public class MidAppLogModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long rowguid;
    private int appId;
    private String appUserName;
    private String immo;
    private String version;
    private int type;
    private String operate;

    private String appName;

    private Date createTime;

    public Long getRowguid() {
        return rowguid;
    }

    public void setRowguid(Long rowguid) {
        this.rowguid = rowguid;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getImmo() {
        return immo;
    }

    public void setImmo(String immo) {
        this.immo = immo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAppUserName() {
        return appUserName;
    }

    public void setAppUserName(String appUserName) {
        this.appUserName = appUserName;
    }
}
