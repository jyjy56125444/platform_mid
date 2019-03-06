package com.platform.mid.controller;

import com.platform.mid.entity.MidAppLogModel;
import com.platform.mid.service.MidAppLogService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 作者： 王一凡
 * 创建时间： 2019/2/21
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.controller
 */
@RestController
public class MidAppLogController {
    @Autowired
    private MidAppLogService midAppLogService;

    /**
     * 查看列表
     */
    @RequestMapping("/mid/app/log/list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<MidAppLogModel> appList = midAppLogService.queryList(query);
        int total = midAppLogService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(appList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }
}
