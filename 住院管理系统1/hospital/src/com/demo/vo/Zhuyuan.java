package com.demo.vo;

import java.io.Serializable;

/**
 * 住院（t_zhuyuan表对应的Java实体类）
 */
public class Zhuyuan implements Serializable {
    private Long id;//主键
    private String zhuyuanName;//姓名
    private String zhuyuanHao;//住院号
    private String zhuyuanSex;//性别:男/女
    private String zhuyuanKeshi;//科室
    private String zhuyuanBingfanghao;//病房号
    private String zhuyuanTime;//入院时间
    private String zhuyuanYishi;//护理医师
    private String zhuyuanText;//备注

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getZhuyuanName() {
        return zhuyuanName;
    }

    public void setZhuyuanName(String zhuyuanName) {
        this.zhuyuanName = zhuyuanName;
    }
    public String getZhuyuanHao() {
        return zhuyuanHao;
    }

    public void setZhuyuanHao(String zhuyuanHao) {
        this.zhuyuanHao = zhuyuanHao;
    }
    public String getZhuyuanSex() {
        return zhuyuanSex;
    }

    public void setZhuyuanSex(String zhuyuanSex) {
        this.zhuyuanSex = zhuyuanSex;
    }
    public String getZhuyuanKeshi() {
        return zhuyuanKeshi;
    }

    public void setZhuyuanKeshi(String zhuyuanKeshi) {
        this.zhuyuanKeshi = zhuyuanKeshi;
    }
    public String getZhuyuanBingfanghao() {
        return zhuyuanBingfanghao;
    }

    public void setZhuyuanBingfanghao(String zhuyuanBingfanghao) {
        this.zhuyuanBingfanghao = zhuyuanBingfanghao;
    }
    public String getZhuyuanTime() {
        return zhuyuanTime;
    }

    public void setZhuyuanTime(String zhuyuanTime) {
        this.zhuyuanTime = zhuyuanTime;
    }
    public String getZhuyuanYishi() {
        return zhuyuanYishi;
    }

    public void setZhuyuanYishi(String zhuyuanYishi) {
        this.zhuyuanYishi = zhuyuanYishi;
    }
    public String getZhuyuanText() {
        return zhuyuanText;
    }

    public void setZhuyuanText(String zhuyuanText) {
        this.zhuyuanText = zhuyuanText;
    }
}
