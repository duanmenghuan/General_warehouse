package cn.yiplatform.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @date 2022/4/28-22:15
 */
@Data
public class ProvinceData implements Serializable {

    private Integer confirm;

    private Integer curConfirm;

    private Integer died;

    private Integer heal;

    private String xArea;

}
