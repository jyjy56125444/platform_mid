package com.platform.mid.controller;

import com.platform.mid.entity.MidAppH5UrlModel;
import com.platform.mid.entity.MidAppModel;
import com.platform.mid.entity.MidAppUrlModel;
import com.platform.mid.entity.MidAppVersionModel;
import com.platform.mid.service.MidAppH5UrlService;
import com.platform.mid.service.MidAppService;
import com.platform.mid.service.MidAppUrlService;
import com.platform.mid.service.MidAppVersionService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;
import jline.internal.Log;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    /**
     * 查看列表
     */
    @RequestMapping("/mid/app/list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

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
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("type", type);
        List<MidAppModel> appList = midAppService.queryListAll(map);
        return R.ok().put("apps", appList);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/mid/app/{id}")
    public R info(@PathVariable("id") String id) {
        MidAppModel app = midAppService.queryObject(id);

        return R.ok().put("app", app);
    }

    /**
     * 修改
     */
    @RequestMapping("/mid/app/update")
    public R update(@RequestBody MidAppModel app) {
        app.setUpdateTime(new Date());
        midAppService.update(app);
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
        return R.ok();
    }
}
