package com.platform.api;

import com.platform.entity.AppInfoVo;
import com.platform.entity.MidUrlH5Vo;
import com.platform.entity.MidUrlVo;
import com.platform.service.ApiMidUrlH5Service;
import com.platform.service.ApiMidUrlService;
import com.platform.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 作者： 王一凡
 * 创建时间： 2019/3/1
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.api
 */
@Api(tags = "API路由信息获取")
@RestController
@RequestMapping("/mid/api")
public class ApiAppInfoController {
    @Autowired
    private ApiMidUrlService urlService;
    @Autowired
    private ApiMidUrlH5Service urlh5Service;

    /**
     * 查看信息
     */
    @ApiOperation(value = "获取app接口&H5页面地址信息")
    @GetMapping("info/{appId}")
    public R info(@PathVariable String appId) {
        //注入get请求参数
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("appId", appId);
        //组织返回数据
        MidUrlVo url = urlService.queryObject(map);
        MidUrlH5Vo h5 = urlh5Service.queryObject(map);
        String itUrl = "";
        if(url.getAppUrlStatus()==0){
            itUrl = url.getAppUrlTest();
        }else{
            itUrl = url.getAppUrlFormat();
        }
        String h5Url = "";
        if(h5.getAppH5UrlStatus()==0){
            h5Url = h5.getAppH5UrlTest();
        }else{
            h5Url = h5.getAppH5UrlFormat();
        }
        AppInfoVo info = new AppInfoVo();
        info.setAppId(appId);
        info.setItUrl(itUrl);
        info.setH5Url(h5Url);

        return R.ok().put("url", info);
    }
}
