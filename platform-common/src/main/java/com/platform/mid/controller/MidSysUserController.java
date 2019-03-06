package com.platform.mid.controller;

import com.platform.annotation.SysLog;
import com.platform.mid.entity.MidAppInfoModel;
import com.platform.mid.entity.MidSysUserModel;
import com.platform.mid.entity.MidSysUserPwdModel;
import com.platform.mid.service.MidSysUserService;
import com.platform.utils.*;
import com.platform.validator.Assert;
import jline.internal.Log;
import org.apache.http.util.TextUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.platform.utils.ShiroUtils.getUserId;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/21
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.controller
 */
@RestController
public class MidSysUserController {
    @Autowired
    private MidSysUserService midSysUserService;

    /**
     * 查看列表
     */
    @RequestMapping("/mid/sys/user/list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<MidSysUserModel> appList = midSysUserService.queryList(query);
        int total = midSysUserService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(appList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/mid/sys/user/{id}")
    public R info(@PathVariable("id") String id) {
        MidSysUserModel user = midSysUserService.queryObject(id);

        return R.ok().put("user", user);
    }

    /**
     * 修改
     */
    @RequestMapping("/mid/sys/user/update")
    public R update(@RequestBody MidSysUserModel user) {
        midSysUserService.update(user);
        return R.ok();
    }

    /**
     * 保存
     */
    @RequestMapping("/mid/sys/user/save")
    public R save(@RequestBody MidSysUserModel user) {
        String password = user.getUserPwd();
        if(!TextUtils.isEmpty(password)) {
            //密码加密
            user.setUserPwd(new Sha256Hash(password).toHex());
        }
        user.setCreateTime(new Date());
        midSysUserService.save(user);

        return R.ok();
    }

    /**
     * 修改登录用户密码
     */
    @SysLog("修改密码")
    @RequestMapping("/mid/sys/user/password")
    public R password(@RequestBody MidSysUserPwdModel pwd) {
        //用户id赋值
        pwd.setUserId(getUserId());
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
}
