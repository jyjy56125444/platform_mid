package com.platform.api;

import com.platform.entity.DownloadVo;
import com.platform.service.ApiDownloadService;
import com.platform.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 作者： 王一凡
 * 创建时间： 2019/3/7
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.api
 */
@Api(tags = "API应用下载统计")
@RestController
@RequestMapping("/mid/api")
public class ApiDownloadController {
    @Autowired
    private ApiDownloadService downloadService;

    /**
     * 保存
     */
    @ApiOperation(value = "上传app下载记录")
    @PostMapping("download")
    public R save(@RequestBody DownloadVo download) {
        download.setDownLoadTime(new Date());
        downloadService.save(download);
        return R.ok();
    }
}
