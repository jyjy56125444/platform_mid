package com.platform.mid.controller;

import com.platform.mid.entity.*;
import com.platform.mid.service.*;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;
import com.platform.utils.ShiroUtils;
import jline.internal.Log;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.platform.utils.ShiroUtils.getUserId;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/14
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.controller
 */
@RestController
public class MidAppController {
    @Autowired
    private MidAppService midAppService;
    @Autowired
    private MidAppVersionService midAppInfoService;
    @Autowired
    private MidAppUrlService midAppUrlService;
    @Autowired
    private MidAppH5UrlService midAppH5UrlService;
    @Autowired
    private MidAppAuthService midAppAuthService;

    private static int ADMIN = 1;
    /**
     * 查看列表
     */
    @RequestMapping("/mid/app/list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        if(ShiroUtils.getUserEntity() != null) {
            int user = ShiroUtils.getUserEntity().getUserGuid();
            query.put("userGuid", user);
        }
        List<MidAppModel> appList = midAppService.queryList(query);
        int total = midAppService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(appList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查询全部
     */
    @RequestMapping("/mid/app/listAll")
    public R listAll(@RequestParam Map<String, Object> params) {
        String fucType = params.get("type").toString();
        String type = "";
        if(!TextUtils.isEmpty(fucType)) {
            if (fucType.equals("base")) {
                type = "mobile_base_info";
            } else if (fucType.equals("info")) {
                type = "mobile_app_info";
            }
        }
        //注入get请求参数
        params.put("type", type);
        if(ShiroUtils.getUserEntity() != null) {
            int user = ShiroUtils.getUserEntity().getUserGuid();
            params.put("userGuid", user);
        }
        List<MidAppModel> appList = midAppService.queryListAll(params);
        return R.ok().put("apps", appList);
    }

    /**
     * 按用户查询
     */
    @RequestMapping("/mid/app/listMy")
    public R listUser(@RequestParam Map<String, Object> params) {
        if(ShiroUtils.getUserEntity() != null) {
            int user = ShiroUtils.getUserEntity().getUserGuid();
            params.put("userGuid", user);
        }
        List<MidAppModel> appList = midAppService.queryListByUser(params);
        return R.ok().put("apps", appList);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/mid/app/{id}")
    public R info(@PathVariable("id") String id) {
        MidAppModel app = midAppService.queryObject(id);
        //查询相关权限信息
        List<MidAppAuthModel> auth = midAppAuthService.queryObjectDataList(id);
        app.setAuth(auth);
        return R.ok().put("app", app);
    }

    /**
     * 修改
     */
    @RequestMapping("/mid/app/update")
    public R update(@RequestBody MidAppModel app) {
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

    /**
     * 保存
     */
    @RequestMapping("/mid/app/save")
    public R save(@RequestBody MidAppModel app) {
        //保存app信息
        app.setCreateTime(new Date());
        app.setUpdateTime(new Date());
        midAppService.save(app);
        //获取app的appId
        MidAppModel thisApp = midAppService.queryObjectByName(app.getAppName());
        //存储app对应的版本信息
        MidAppVersionModel version = new MidAppVersionModel();
        version.setAppId(thisApp.getAppId());
        version.setVersion("1.0.0");
        version.setCreateTime(new Date());
        version.setCreator(app.getCreator());
        version.setUpdateTime(new Date());
        version.setUpdater(app.getUpdater());
        if(app.getAppType()==0) {
            version.setVersionType(1);
            midAppInfoService.save(version);
            version.setVersionType(2);
            midAppInfoService.save(version);
        }else{
            version.setVersionType(app.getAppType());
            midAppInfoService.save(version);
        }
        //存储app对应的接口地址信息
        MidAppUrlModel url = new MidAppUrlModel();
        url.setAppId(thisApp.getAppId());
        url.setAppUrlType(0);
        url.setAppUrlStatus(0);
        url.setCreateTime(new Date());
        url.setCreator(app.getCreator());
        url.setUpdateTime(new Date());
        url.setUpdater(app.getUpdater());
        midAppUrlService.save(url);
        //存储app对应的H5页面地址信息
        MidAppH5UrlModel h5Url = new MidAppH5UrlModel();
        h5Url.setAppId(thisApp.getAppId());
        h5Url.setAppH5UrlType(0);
        h5Url.setAppH5UrlStatus(0);
        h5Url.setCreateTime(new Date());
        h5Url.setCreator(app.getCreator());
        h5Url.setUpdateTime(new Date());
        h5Url.setUpdater(app.getUpdater());
        midAppH5UrlService.save(h5Url);
        //存储app对应的权限信息
        List<Integer> userList = new ArrayList<>();
        List<MidAppAuthModel> auth = app.getAuth();
        if(auth !=null && auth.size()>0) {
            for (MidAppAuthModel m : auth) {
                userList.add(m.getUserGuid());
            }
            //默认添加管理员
            if(!userList.contains(ADMIN)){
                userList.add(ADMIN);
            }
            Map<String, Object> map = new HashMap<>();
            map.put("appId", thisApp.getAppId());
            map.put("userList", userList);
            midAppAuthService.save(map);
        }


        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/mid/app/delete")
    public R delete(@RequestBody Integer[] ids) {
        midAppService.deleteBatch(ids);
        midAppUrlService.deleteBatch(ids);
        midAppH5UrlService.deleteBatch(ids);
        midAppAuthService.deleteBatch(ids);
        return R.ok();
    }
}
