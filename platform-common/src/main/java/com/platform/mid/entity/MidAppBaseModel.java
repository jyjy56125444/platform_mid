package com.platform.mid.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/18
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.entity
 */
public class MidAppBaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private int appId;
    private String developer;
    private String interfaceDeveloper;
    private String designer;
    private String remark;
    private Date createTime;
    private Date updateTime;
    private String creator;
    private String updater;

    private String appName;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getInterfaceDeveloper() {
        return interfaceDeveloper;
    }

    public void setInterfaceDeveloper(String interfaceDeveloper) {
        this.interfaceDeveloper = interfaceDeveloper;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
