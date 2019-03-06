package com.platform.shiro;

import jline.internal.Log;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 作者： 王一凡
 * 创建时间： 2019/1/16
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.shiro
 */
public class PermissionsAuthorizationFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return true;
    }
}
