package com.platform.shiro;

import com.platform.mid.dao.MidSysMenuDao;
import com.platform.mid.dao.MidSysUserDao;
import com.platform.mid.entity.MidSysUserModel;
import com.platform.utils.Constant;
import jline.internal.Log;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 认证
 *
 * @author lipengjun
 * @date 2017年11月19日 上午9:49:19
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private MidSysUserDao sysUserDao;
    @Autowired
    private MidSysMenuDao sysMenuDao;

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Log.info("进入UserRealm");
        MidSysUserModel user = (MidSysUserModel) principals.getPrimaryPrincipal();
        int userId = user.getUserGuid();

//        List<String> permsList = (List<String>) J2CacheUtils.get(Constant.PERMS_LIST + userId);
//
//        //用户权限列表
//        Set<String> permsSet = new HashSet<String>();
//        if (permsList != null && permsList.size() != 0) {
//            for (String perms : permsList) {
//                if (StringUtils.isBlank(perms)) {
//                    continue;
//                }
//                permsSet.addAll(Arrays.asList(perms.trim().split(",")));
//            }
//        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.setStringPermissions(permsSet);
        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        Log.info("进入登陆验证");
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        //查询用户信息
        MidSysUserModel user = sysUserDao.queryByUserName(username);

        //账号不存在
        if (user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }

        //密码错误
        if (!password.equals(user.getUserPwd())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }

        //账号锁定
        if (user.getUserStatus() == 0) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }

        // 把当前用户放入到session中
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession(true);
        session.setAttribute(Constant.CURRENT_USER, user);

        Log.info("通过验证");

//        List<String> permsList;
//
//        //系统管理员，拥有最高权限
//
//        List<SysMenuEntity> menuList = sysMenuDao.queryList(new HashMap<String, Object>());
//        permsList = new ArrayList<>(menuList.size());
//        for (SysMenuEntity menu : menuList) {
//            permsList.add(menu.getPerms());
//        }
//
//        J2CacheUtils.put(Constant.PERMS_LIST + user.getUserGuid(), permsList);

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }

}
