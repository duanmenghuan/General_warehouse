package com.demo.vo;

import java.io.Serializable;

public class Drug  implements Serializable {
    private Long id;//Ö÷¼ü
    private String name;
    private String supplier;
    private String initialtime;
    private String expirationdate;
    private String pesticideeffect;
    private String remark;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getInitialtime() {
        return initialtime;
    }

    public void setInitialtime(String initialtime) {
        this.initialtime = initialtime;
    }

    public String getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(String expirationdate) {
        this.expirationdate = expirationdate;
    }

    public String getPesticideeffect() {
        return pesticideeffect;
    }

    public void setPesticideeffect(String pesticideeffect) {
        this.pesticideeffect = pesticideeffect;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
