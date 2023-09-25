package cn.yiplatform.service;

import java.util.List;
import java.util.Map;

/**
 *
 * @date 2022/3/21-16:48
 */
public interface EpidemicService {
    /**
     * 获取疫情最新资讯
     * @return
     */
    String getLatestNews();

    /**
     * 获取国内病例数据
     * @return
     */
    List getDiseaseData();

    /**
     * 获取风险地区
     * @return
     */
    Map getRiskArea();
}
