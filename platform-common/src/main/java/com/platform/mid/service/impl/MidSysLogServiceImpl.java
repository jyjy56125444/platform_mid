package com.platform.mid.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.platform.mid.dao.MidSysLogDao;
import com.platform.mid.entity.MidSysLogModel;
import com.platform.mid.service.MidSysLogService;
import jline.internal.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * 作者： 王一凡
 * 创建时间： 2019/1/21
 * 版权： 江苏远大信息股份有限公司
 * 描述： com.platform.mid.service.impl
 */
@Service("midSysLogService")
public class MidSysLogServiceImpl implements MidSysLogService {
    @Autowired
    private MidSysLogDao midSysLogDao;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public MidSysLogModel queryObject(Long id) {
        return midSysLogDao.queryObject(id);
    }

    @Override
    public List<MidSysLogModel> queryList(Map<String, Object> map) {
        List<MidSysLogModel> list = midSysLogDao.queryList(map);

//        for (MidSysLogModel sysLogEntity : list) {
//            sysLogEntity.setUserIP(getIpDetails(sysLogEntity.getUserIP()));
//        }
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return midSysLogDao.queryTotal(map);
    }

    @Override
    public void save(MidSysLogModel sysLog) {
        sysLog.setUserIP(getIpDetails(sysLog.getUserIP()));
        midSysLogDao.save(sysLog);
    }

    @Override
    public void update(MidSysLogModel sysLog) {
        midSysLogDao.update(sysLog);
    }

    @Override
    public void delete(Long id) {
        midSysLogDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        midSysLogDao.deleteBatch(ids);
    }

    /**
     * 向指定URL发送GET方法的请求
     */
    public  String getIpDetails(String ip) {
        String str=null;
        if(ip.startsWith("0:") ||ip.startsWith("0.") || ip.startsWith("127.") ){
            return "127.0.0.1 本地访问";
        }
        try {
            str = restTemplate.getForObject("http://ip.taobao.com/service/getIpInfo.php?ip="+ip, String.class);
            JSONObject jsonObject = JSONObject.parseObject(str.toString());
            if(jsonObject.getInteger("code") == 0) {
                //{"code":0,"data":{"ip":"1.1.1.1","country":"澳大利亚","area":"","region":"XX","city":"XX","county":"XX","isp":"XX","country_id":"AU","area_id":"","region_id":"xx","city_id":"xx","county_id":"xx","isp_id":"xx"}}
                jsonObject = (JSONObject) jsonObject.get("data");
                str = ip + ":" + jsonObject.getString("country") + " " + jsonObject.getString("region") + " "
                        + jsonObject.getString("city")  + " " + jsonObject.getString("isp");
            }else{
                str = ip;
            }
        } catch (RestClientException e) {
            str = ip;
        }
        return str;
    }
}
