package com.demo.vo;

import java.io.Serializable;

/**
 * 病房（t_bingfang表对应的Java实体类）
 */
public class Bingfang implements Serializable {
    private Long id;//主键
    private String bingfangNo;//病房号
    private String bingfangName;//科室
    private String bingfangType;//类型:普通/重症
    private String bingfangCount;//容量
    private String bingfangPrice;//价格
    private String bingfangText;//详情

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getBingfangNo() {
        return bingfangNo;
    }

    public void setBingfangNo(String bingfangNo) {
        this.bingfangNo = bingfangNo;
    }
    public String getBingfangName() {
        return bingfangName;
    }

    public void setBingfangName(String bingfangName) {
        this.bingfangName = bingfangName;
    }
    public String getBingfangType() {
        return bingfangType;
    }

    public void setBingfangType(String bingfangType) {
        this.bingfangType = bingfangType;
    }
    public String getBingfangCount() {
        return bingfangCount;
    }

    public void setBingfangCount(String bingfangCount) {
        this.bingfangCount = bingfangCount;
    }
    public String getBingfangPrice() {
        return bingfangPrice;
    }

    public void setBingfangPrice(String bingfangPrice) {
        this.bingfangPrice = bingfangPrice;
    }
    public String getBingfangText() {
        return bingfangText;
    }

    public void setBingfangText(String bingfangText) {
        this.bingfangText = bingfangText;
    }
}
