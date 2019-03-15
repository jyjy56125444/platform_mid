package com.platform.mid.controller;

import com.platform.mid.entity.MidAppUrlModel;
import com.platform.mid.entity.MidAppVersionModel;
import com.platform.mid.service.MidAppUrlService;
import com.platform.utils.R;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/20
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.controller
 */
@RestController
public class MidAppUrlController {
    @Autowired
    private MidAppUrlService midAppUrlService;

    /**
     * 查看信息
     */
    @RequestMapping("/mid/app/url/{id}")
    public R info(@PathVariable("id") String id) {
        MidAppUrlModel url = midAppUrlService.queryObject(id);
        if(TextUtils.isEmpty(url.getInterfaceDeveloper())){
            url.setInterfaceDeveloper("未录入");
        }
        switch (url.getAppType()){
            case 0:
                url.setAppTypeName("Android/IOS");
                break;
            case 1:
                url.setAppTypeName("Android");
                break;
            case 2:
                url.setAppTypeName("IOS");
                break;
            case 3:
                url.setAppTypeName("小程序");
                break;
            default:
                break;
        }
        return R.ok().put("app", url);
    }

    /**
     * 修改
     */
    @RequestMapping("/mid/app/url/update")
    public R update(@RequestBody MidAppUrlModel url) {
        url.setUpdateTime(new Date());
        midAppUrlService.update(url);
        return R.ok();
    }

}
