package cn.yiplatform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName temperature_report
 */
@TableName(value ="temperature_report")
@Data
public class TemperatureReport implements Serializable {
    /**
     * 报告id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
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
     * 体温
     */
    private Double temperature;

    /**
     * 提交时间
     */
    private Date submitTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}