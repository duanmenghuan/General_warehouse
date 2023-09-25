package cn.yiplatform.service.impl;

import cn.yiplatform.entity.ProvinceData;
import cn.yiplatform.service.EpidemicService;
import cn.yiplatform.utils.CommonUtil;
import cn.yiplatform.utils.HttpClientUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 *
 * @date 2022/3/21-16:50
 */
@Repository
@DubboService(interfaceClass = EpidemicService.class, version = "1.0", timeout = 1800000000)
public class EpidemicServiceImpl implements EpidemicService {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    private String key = "ca8ef88708bfb8ae498d6a6008b34989";

    @Override
    public String getLatestNews() {
        CloseableHttpClient httpClient = null;
        HttpGet httpGet = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClientBuilder.create().build();
            httpGet = new HttpGet("https://ent.163.com/special/00035080/virus_report_data.js");
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(entity);
            return CommonUtil.getContentInBrace(s);
        } catch (IOException e) {
            logger.error("最新疫情资讯获取失败", e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpGet != null) {
                try {
                    httpGet.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    @Override
    public List getDiseaseData() {
        CloseableHttpClient httpClient = null;
        HttpGet httpGet = null;
        CloseableHttpResponse response = null;
        String url = "https://uaqy.api.storeapi.net/api/94/219";
        String appId = "16733";
        String secret = "b400882b136bff5a97aa3a6d6d2dfe44";
        Map<String, String> data = new HashMap<>();
        data.put("appid", "16733");
        data.put("format", "json");
        data.put("time", String.valueOf(new Date().getTime()));
        ArrayList<Object> params = new ArrayList<>();
        String md5String = "";
        for(String key: data.keySet()) {
            md5String += key + data.get(key);
            params.add(key + "=" + data.get(key));
        }
        md5String += secret;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        String sign = Hex.encodeHexString(md.digest(md5String.getBytes(StandardCharsets.UTF_8)));
        params.add("sign=" + sign);
        String urlParam = StringUtils.join(params, "&");
        try {
            httpClient = HttpClientBuilder.create().build();
            httpGet = new HttpGet(url + "?" + urlParam);
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(entity);
            Map<String, Object> resMap = JSON.parseObject(s, Map.class);
            if ((Integer) resMap.get("codeid") == 10000) {
                List resultList = new ArrayList();
                List provinceDataList = new ArrayList();
                if (resMap.containsKey("retdata") && !Objects.isNull(resMap.get("retdata"))) {
                    resultList = (List)resMap.get("retdata");
                    for (Object o : resultList) {
                        ProvinceData provinceData1 = JSON.parseObject(String.valueOf(o), ProvinceData.class);
                        provinceDataList.add(provinceData1);
                    }
                    Collections.sort(provinceDataList, new Comparator<ProvinceData>() {
                        @Override
                        public int compare(ProvinceData o1, ProvinceData o2) {
                            int i = o2.getCurConfirm().compareTo(o1.getCurConfirm());
                            if (i == 0) {
                                i = o2.getConfirm().compareTo(o1.getConfirm());
                            }
                            return i;
                        }
                    });
                    return provinceDataList;
                }
            }


        } catch (IOException e) {
            logger.error("最新疫情资讯获取失败", e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpGet != null) {
                try {
                    httpGet.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new ArrayList();
    }

    @Override
    public Map getRiskArea() {
        String url = "http://apis.juhe.cn/springTravel/risk?key=" + key;
        Map result = new HashMap();
        try {
            Map<String, Object> resultMap = JSON.parseObject(HttpClientUtil.doGet(url), Map.class);
            Object data= resultMap.get("result");
            if (Objects.isNull(data)) {
                result.put("reason", resultMap.get("reason"));
            } else {
                result = JSON.parseObject(JSON.toJSONString(data), Map.class);
            }
        } catch (Exception e) {
            logger.error("风险地区获取失败", e);
        }
        return result;
    }
}
