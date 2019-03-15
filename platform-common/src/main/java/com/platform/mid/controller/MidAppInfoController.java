package com.platform.mid.controller;

import com.platform.mid.entity.MidAppBaseModel;
import com.platform.mid.entity.MidAppInfoModel;
import com.platform.mid.entity.MidAppUrlModel;
import com.platform.mid.service.MidAppInfoService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;
import com.platform.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/18
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.controller
 */
@RestController
public class MidAppInfoController {
    @Autowired
    private MidAppInfoService midAppInfoService;

    /**
     * 查看列表
     */
    @RequestMapping("/mid/app/info/list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        if(ShiroUtils.getUserEntity() != null) {
            int user = ShiroUtils.getUserEntity().getUserGuid();
            query.put("userGuid", user);
        }
        List<MidAppInfoModel> appList = midAppInfoService.queryList(query);
        int total = midAppInfoService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(appList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/mid/app/info/{id}")
    public R info(@PathVariable("id") String id) {
        MidAppInfoModel app = midAppInfoService.queryObject(id);

        return R.ok().put("app", app);
    }

    /**
     * 修改
     */
    @RequestMapping("/mid/app/info/update")
    public R update(@RequestBody MidAppInfoModel app) {
        app.setUpdateTime(new Date());
        midAppInfoService.update(app);

        return R.ok();
    }

    /**
     * 保存
     */
    @RequestMapping("/mid/app/info/save")
    public R save(@RequestBody MidAppInfoModel app) {
        app.setCreateTime(new Date());
        app.setUpdateTime(new Date());
        midAppInfoService.save(app);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/mid/app/info/delete")
    public R delete(@RequestBody Integer[] ids) {
        midAppInfoService.deleteBatch(ids);

        return R.ok();
    }
}
