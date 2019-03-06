package com.platform.mid.controller;

import com.platform.mid.entity.MidAppModel;
import com.platform.mid.entity.MidAppVersionModel;
import com.platform.mid.service.MidAppVersionService;
import com.platform.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/19
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.controller
 */
@RestController
public class MidAppVersionController {
    @Autowired
    private MidAppVersionService midAppInfoService;

    /**
     * 查看信息
     */
    @RequestMapping("/mid/app/version/{id}")
    public R info(@PathVariable("id") String id) {
        List<MidAppVersionModel> versions = midAppInfoService.queryObject(id);
        for(MidAppVersionModel version:versions){
            switch (version.getVersionType()){
                case 1:
                    version.setVersionTypeName("Android");
                    break;
                case 2:
                    version.setVersionTypeName("IOS");
                    break;
                case 3:
                    version.setVersionTypeName("小程序");
                    break;
                default:
                    break;
            }
        }
        return R.ok().put("app", versions);
    }

    /**
     * 修改
     */
    @RequestMapping("/mid/app/version/update")
    public R update(@RequestBody MidAppVersionModel version) {
        version.setUpdateTime(new Date());
        midAppInfoService.update(version);
        return R.ok();
    }
}
