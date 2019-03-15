package com.platform.mid.controller;

import com.platform.mid.entity.*;
import com.platform.mid.service.*;
import com.platform.utils.R;
import com.platform.utils.ShiroUtils;
import org.apache.http.util.TextUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static com.platform.utils.ShiroUtils.getUserId;

/**
 * 作者： 王一凡
 * 创建时间： 2019/3/14
 * 版权： 江苏远大信息股份有限公司
 * 描述： 钉钉接口集合 适配form-data格式请求
 */
@RestController
@RequestMapping("/mid/dd")
public class MidDDController {
    @Autowired
    private MidAppService midAppService;
    @Autowired
    private MidAppAuthService midAppAuthService;
    @Autowired
    private MidAppUrlService midAppUrlService;
    @Autowired
    private MidAppH5UrlService midAppH5UrlService;
    @Autowired
    private MidSysUserService midSysUserService;

    private static int ADMIN = 1;

    @RequestMapping("app/update")
    public R update(MidAppModel app) {
        app.setUpdateTime(new Date());
        midAppService.update(app);
        //更新app对应的权限信息
        List<Integer> userList = new ArrayList<>();
        List<MidAppAuthModel> auth = app.getAuth();
        if(auth !=null && auth.size()>0) {
            Integer[] ids = {app.getAppId()};
            //删除app对应的权限信息
            midAppAuthService.deleteBatch(ids);
            for (MidAppAuthModel m : auth) {
                userList.add(m.getUserGuid());
            }
            //默认添加管理员
            if(!userList.contains(ADMIN)){
                userList.add(ADMIN);
            }
            Map<String, Object> map = new HashMap<>();
            map.put("appId", app.getAppId());
            map.put("userList", userList);
            midAppAuthService.save(map);
        }

        return R.ok();
    }

    @RequestMapping("app/url/update")
    public R update(MidAppUrlModel url) {
        url.setUpdateTime(new Date());
        midAppUrlService.update(url);
        return R.ok();
    }

    @RequestMapping("app/h5url/update")
    public R update(MidAppH5UrlModel url) {
        url.setUpdateTime(new Date());
        midAppH5UrlService.update(url);
        return R.ok();
    }

    @RequestMapping("sys/user/password")
    public R password(MidSysUserPwdModel pwd) {
        //用户id赋值
        if(ShiroUtils.getUserEntity()!=null) {
            pwd.setUserId(getUserId());
        }
        //进行非空判断
        if(TextUtils.isEmpty(pwd.getPassword())){
            return R.error("原密码不为能空");
        }
        if(TextUtils.isEmpty(pwd.getNewPassword())){
            return R.error("新密码不为能空");
        }
        //sha256加密
        String password = new Sha256Hash(pwd.getPassword()).toHex();
        //sha256加密
        String newPassword = new Sha256Hash(pwd.getNewPassword()).toHex();

        //对象重新赋值
        pwd.setPassword(password);
        pwd.setNewPassword(newPassword);

        //更新密码
        int count = midSysUserService.updatePassword(pwd);

        if (count == 0) {
            return R.error("原密码不正确");
        }

        return R.ok();
    }

    @RequestMapping("sys/user/update")
    public R update(MidSysUserModel user) {
        midSysUserService.update(user);
        return R.ok();
    }
}
