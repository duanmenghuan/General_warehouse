package cn.yiplatform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 疫苗接种记录
 * @TableName vaccination_record
 */
@TableName(value ="vaccination_record")
@Data
public class VaccinationRecord implements Serializable {
    /**
     * 疫苗接种记录
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 受种人id
     */
    private Long uid;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 受种者编号
     */
    private String code;

    /**
     * 疫苗名称
     */
    private String vaccine;

    /**
     * 剂次
     */
    private Integer dose;

    /**
     * 接种日期
     */
    private Date inoculationDate;

    /**
     * 疫苗批号
     */
    private String lot;

    /**
     * 生产企业
     */
    private String manufacture;

    /**
     * 接种单位
     */
    private String clinic;

    /**
     * 提交时间
     */
    private Date submitTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}