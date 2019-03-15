package com.platform.service;

import com.platform.dao.ApiDownloadMapper;
import com.platform.entity.DownloadVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者： 王一凡
 * 创建时间： 2019/3/7
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.service
 */
@Service
public class ApiDownloadService {
    @Autowired
    private ApiDownloadMapper downloadDao;

    public int save(DownloadVo download) {
        return downloadDao.save(download);
    }
}
