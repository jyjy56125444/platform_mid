package com.platform.api;

import com.platform.entity.AppLogVo;
import com.platform.service.ApiAppLogService;
import com.platform.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * 作者： 王一凡
 * 创建时间： 2019/3/1
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.api
 */
@Api(tags = "API应用日志上传")
@RestController
@RequestMapping("/mid/api")
public class ApiAppLogController {
    @Autowired
    private ApiAppLogService logService;

    /**
     * 保存
     */
    @ApiOperation(value = "上传app日志信息")
    @PostMapping("log")
    public R save(@RequestBody AppLogVo log) {
        log.setCreateTime(new Date());
        logService.save(log);

        return R.ok();
    }
}
