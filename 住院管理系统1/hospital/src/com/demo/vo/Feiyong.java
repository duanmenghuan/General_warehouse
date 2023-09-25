package com.demo.vo;

import java.io.Serializable;

/**
 * 费用（t_feiyong表对应的Java实体类）
 */
public class Feiyong implements Serializable {
    private Long id;//主键
    private String feiyongNo;//账单号
    private String feiyongZhuyuanhao;//住院号
    private String feiyongName;//付款人
    private String feiyongJine;//金额
    private String feiyongJiaofeifangshi;//缴费方式:现金/转帐
    private String feiyongJiaofeishijian;//缴费时间
    private String feiyongText;//备注

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getFeiyongNo() {
        return feiyongNo;
    }

    public void setFeiyongNo(String feiyongNo) {
        this.feiyongNo = feiyongNo;
    }
    public String getFeiyongZhuyuanhao() {
        return feiyongZhuyuanhao;
    }

    public void setFeiyongZhuyuanhao(String feiyongZhuyuanhao) {
        this.feiyongZhuyuanhao = feiyongZhuyuanhao;
    }
    public String getFeiyongName() {
        return feiyongName;
    }

    public void setFeiyongName(String feiyongName) {
        this.feiyongName = feiyongName;
    }
    public String getFeiyongJine() {
        return feiyongJine;
    }

    public void setFeiyongJine(String feiyongJine) {
        this.feiyongJine = feiyongJine;
    }
    public String getFeiyongJiaofeifangshi() {
        return feiyongJiaofeifangshi;
    }

    public void setFeiyongJiaofeifangshi(String feiyongJiaofeifangshi) {
        this.feiyongJiaofeifangshi = feiyongJiaofeifangshi;
    }
    public String getFeiyongJiaofeishijian() {
        return feiyongJiaofeishijian;
    }

    public void setFeiyongJiaofeishijian(String feiyongJiaofeishijian) {
        this.feiyongJiaofeishijian = feiyongJiaofeishijian;
    }
    public String getFeiyongText() {
        return feiyongText;
    }

    public void setFeiyongText(String feiyongText) {
        this.feiyongText = feiyongText;
    }
}
