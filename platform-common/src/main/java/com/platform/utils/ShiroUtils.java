package com.platform.utils;

import com.platform.mid.entity.MidSysUserModel;
import jline.internal.Log;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Shiro工具类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2016年11月12日 上午9:49:19
 */
public class ShiroUtils {

    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static MidSysUserModel getUserEntity() {
        return (MidSysUserModel) SecurityUtils.getSubject().getPrincipal();
    }

    public static int getUserId() {
        return getUserEntity().getUserGuid();
    }

    public static void setSessionAttribute(Object key, Object value) {
        if(getSession()==null) {
            Log.info("【set】getSession为null");
        }else{
            Log.info("【set】getSession成功获取");
            Log.info("【set】SessionId:"+getSession().getId());
        }
        getSession().setAttribute(key, value);
    }

    public static Object getSessionAttribute(Object key) {
        if(getSession()==null) {
            Log.info("【get】getSession为null");
        }else{
            Log.info("【get】getSession成功获取");
            Log.info("【get】SessionId:"+getSession().getId());
        }
        return getSession().getAttribute(key);
    }

    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

    public static String getKaptcha(String key) {
        String kaptcha;
        try {
            kaptcha = getSessionAttribute(key).toString();
            getSession().removeAttribute(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return kaptcha;
    }

}
