package com.platform.mid.controller;

import com.platform.mid.entity.MidAppBaseModel;
import com.platform.mid.service.MidAppBaseService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;
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
public class MidAppBaseController {
    @Autowired
    private MidAppBaseService midAppBaseService;

    /**
     * 查看列表
     */
    @RequestMapping("/mid/app/base/list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<MidAppBaseModel> appList = midAppBaseService.queryList(query);
        int total = midAppBaseService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(appList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/mid/app/base/{id}")
    public R info(@PathVariable("id") String id) {
        MidAppBaseModel app = midAppBaseService.queryObject(id);

        return R.ok().put("app", app);
    }

    /**
     * 修改
     */
    @RequestMapping("/mid/app/base/update")
    public R update(@RequestBody MidAppBaseModel app) {
        app.setUpdateTime(new Date());
        midAppBaseService.update(app);

        return R.ok();
    }

    /**
     * 保存
     */
    @RequestMapping("/mid/app/base/save")
    public R save(@RequestBody MidAppBaseModel app) {
        app.setCreateTime(new Date());
        app.setUpdateTime(new Date());
        midAppBaseService.save(app);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/mid/app/base/delete")
    public R delete(@RequestBody Integer[] ids) {
        midAppBaseService.deleteBatch(ids);

        return R.ok();
    }
}
