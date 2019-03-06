package com.platform.api;

import com.platform.entity.MidVersionVo;
import com.platform.service.ApiMidVersionService;
import com.platform.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 作者： 王一凡
 * 创建时间： 2019/3/1
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.api
 */
@Api(tags = "API应用版本信息获取")
@RestController
@RequestMapping("/mid/api")
public class ApiMidVersionController {
    @Autowired
    private ApiMidVersionService versionService;

    /**
     * 查看信息
     */
    @ApiOperation(value = "获取版本信息")
    @GetMapping("version/{appId}/{appType}")
    public R info(@PathVariable String appId, @PathVariable String appType) {
        //注入get请求参数
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("appId", appId);
        map.put("appType", appType);
        MidVersionVo version = versionService.queryObject(map);
        return R.ok().put("version", version);
    }



}
