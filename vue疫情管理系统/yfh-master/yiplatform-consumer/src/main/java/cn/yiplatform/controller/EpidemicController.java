package cn.yiplatform.controller;

import cn.yiplatform.contants.ResponseStatusCode;
import cn.yiplatform.contants.SysContants;
import cn.yiplatform.service.EpidemicService;
import cn.yiplatform.vo.OperResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @date 2022/3/21-16:57
 */
@RestController
@CrossOrigin
public class EpidemicController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @DubboReference(interfaceClass = EpidemicService.class, version = "1.0", check = false, timeout = 1800000000)
    private EpidemicService epidemicService;

    @GetMapping("/epidemicNews")
    public OperResult getEpidemicNews() {
        String latestNews;
        Map resultMap;
        try {
            latestNews = epidemicService.getLatestNews();
            String substring = latestNews.substring(0, latestNews.length() - 1);
            Object parse = JSON.parse(substring);
            if (Objects.isNull(parse)) {
                return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(),"最新疫情资讯获取失败", SysContants.NULL);
            } else {
                resultMap = JSON.parseObject(substring, Map.class);
                if (resultMap.containsKey("list")) {
                    return new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(),"最新疫情资讯获取成功", resultMap.get("list"));
                }
            }
        } catch (Exception e) {
            logger.error("获取最新疫情资讯 /epidemicNews 异常", e);
            return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(),"最新疫情资讯获取失败", SysContants.NULL);
        }
        return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(),"最新疫情资讯获取失败", SysContants.NULL);
    }

    @GetMapping("/diseaseData")
    public OperResult getDiseaseData() {
        List resultList;
        try {
            resultList = epidemicService.getDiseaseData();
            if (CollectionUtils.isEmpty(resultList)) {
                return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(),"病例数据获取失败", SysContants.NULL);
            } else {
                return new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(),"病例数据获取成功", resultList);
            }
        } catch (Exception e) {
            logger.error("获取病例数据 /diseaseData 异常", e);
            return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(),"病例数据获取异常", SysContants.NULL);
        }
    }

    @GetMapping("/riskAreas")
    public OperResult getRiskAreas() {
        Map riskAreasMap;
        OperResult operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(),"风险地区获取失败", SysContants.NULL);
        try {
            riskAreasMap = epidemicService.getRiskArea();
            if (MapUtils.isEmpty(riskAreasMap)) {
                return operResult;
            } else if (riskAreasMap.containsKey("reason")) {
                operResult = new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.NO.getCode(), riskAreasMap.get("reason").toString(), riskAreasMap);
            } else {
               operResult =  new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(),"风险地区获取成功", riskAreasMap);
            }
        } catch (Exception e) {
            logger.error("获取风险地区 /riskAreas 异常", e);
            return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(),"风险地区获取失败", SysContants.NULL);
        }
        return operResult;
    }
}
