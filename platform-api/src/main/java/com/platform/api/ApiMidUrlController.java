package com.platform.api;

import com.platform.entity.MidUrlVo;
import com.platform.service.ApiMidUrlService;
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
@Api(tags = "API接口地址获取")
@RestController
@RequestMapping("/mid/api")
public class ApiMidUrlController {
    @Autowired
    private ApiMidUrlService urlService;

    /**
     * 查看信息
     */
    @ApiOperation(value = "获取接口地址信息")
    @GetMapping("url/{appId}")
    public R info(@PathVariable String appId) {
        //注入get请求参数
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("appId", appId);
        MidUrlVo url = urlService.queryObject(map);
        return R.ok().put("url", url);
    }
}
