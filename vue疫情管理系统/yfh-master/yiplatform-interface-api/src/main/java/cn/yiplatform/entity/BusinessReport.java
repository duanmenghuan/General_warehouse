package cn.yiplatform.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 员工出差报备信息表
 * @TableName business_report
 */
@TableName(value ="business_report")
@Data
public class BusinessReport implements Serializable {
    /**
     * 出差信息id
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
     * 起始地
     */
    private String startPlace;

    /**
     * 目的地
     */
    private String endPlace;

    /**
     * 出发时间
     */
    private Date beginTime;

    /**
     * 到达时间
     */
    private Date endTime;

    /**
     * 出行工具
     */
    private String trafficTool;

    /**
     * 返回起始时间
     */
    private Date backBeginTime;

    /**
     * 返回到达时间
     */
    private Date backEndTime;

    /**
     * 返回出行工具
     */
    private String backTrafficTool;

    /**
     * 完成状态
     */
    private Integer isComplete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 出差记录状态
     */
    private int status;
    /**
     * 删除状态
     */
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}