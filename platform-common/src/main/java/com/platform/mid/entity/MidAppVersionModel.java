package com.platform.mid.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/19
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.entity
 */
public class MidAppVersionModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private int appId;
    private int versionType;
    private String version;
    private String comment;
    private String downLoadSize;
    private String downLoadUrl;
    private String scanImg;
    private Date createTime;
    private Date updateTime;
    private String creator;
    private String updater;

    private String appName;
    private String versionTypeName;

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getVersionType() {
        return versionType;
    }

    public void setVersionType(int versionType) {
        this.versionType = versionType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDownLoadSize() {
        return downLoadSize;
    }

    public void setDownLoadSize(String downLoadSize) {
        this.downLoadSize = downLoadSize;
    }

    public String getDownLoadUrl() {
        return downLoadUrl;
    }

    public void setDownLoadUrl(String downLoadUrl) {
        this.downLoadUrl = downLoadUrl;
    }

    public String getScanImg() {
        return scanImg;
    }

    public void setScanImg(String scanImg) {
        this.scanImg = scanImg;
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

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersionTypeName() {
        return versionTypeName;
    }

    public void setVersionTypeName(String versionTypeName) {
        this.versionTypeName = versionTypeName;
    }
}
