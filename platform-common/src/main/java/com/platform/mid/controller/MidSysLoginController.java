package com.platform.mid.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.platform.annotation.SysLog;
import com.platform.mid.dao.MidSysUserDao;
import com.platform.mid.entity.MidSysUserModel;
import com.platform.utils.R;
import com.platform.utils.ShiroUtils;
import jline.internal.Log;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 作者： 王一凡
 * 创建时间： 2019/1/22
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.controller
 */
@Controller
public class MidSysLoginController {
    @Autowired
    private Producer producer;
    @Autowired
    private MidSysUserDao sysUserDao;

    @RequestMapping("/mid/captcha.jpg")
    public void captcha(HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        try {
            ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }

    /**
     * 登录
     */
    @SysLog("登录")
    @ResponseBody
    @RequestMapping(value = "/mid/login", method = RequestMethod.POST)
    public R login(String username, String password, String captcha) throws IOException {
        String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        Log.info("后台验证码："+kaptcha);
        if(null == kaptcha){
            return R.error("验证码已失效");
        }
        if (!captcha.equalsIgnoreCase(kaptcha)) {
            return R.error("验证码不正确");
        }

        try {
            Subject subject = ShiroUtils.getSubject();
            //sha256加密
            password = new Sha256Hash(password).toHex();
            Log.info("password:"+password);
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        } catch (UnknownAccountException e) {
            return R.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return R.error(e.getMessage());
        } catch (LockedAccountException e) {
            return R.error(e.getMessage());
        } catch (AuthenticationException e) {
            return R.error("账户验证失败");
        }

        return R.ok();
    }

    /**
     * 登录
     */
    @SysLog("移动端登录")
    @ResponseBody
    @RequestMapping(value = "/mid/appLogin", method = RequestMethod.POST)
    public R appLogin(String username, String password) throws IOException {
        MidSysUserModel user = sysUserDao.queryByUserName(username);
        //账号不存在
        if (user == null) {
            return R.error("账号或密码不正确");
        }
        //密码错误
        if (!password.equals(user.getUserPwd())) {
            return R.error("账号或密码不正确");
        }
        //账号锁定
        if (user.getUserStatus() == 0) {
            return R.error("账号已被锁定,请联系管理员");
        }
        return R.ok().put("user", user);
    }

    /**
     * 退出
     */
    @RequestMapping(value = "/mid/logout", method = RequestMethod.GET)
    public String logout() {
        Log.info("用户注销");
        ShiroUtils.logout();
        return "redirect:" + "https://www.yd-mobile.com";
    }
}
