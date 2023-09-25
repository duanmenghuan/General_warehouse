package cn.yiplatform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 核酸检测报告
 * @TableName nat_report
 */
@TableName(value ="nat_report")
@Data
public class NatReport implements Serializable {
    /**
     * 核酸检测记录id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 检测人id
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
     * 采样地点
     */
    private String samplingLocation;

    /**
     * 送检医生
     */
    private String inspectionDoctor;

    /**
     * 送检时间
     */
    private Date inspectionTime;

    /**
     * 报告医生
     */
    private String reportDoctor;

    /**
     * 报告时间
     */
    private Date reportTime;

    /**
     * 检测结果
     */
    private String checkResult;

    /**
     * 报告提交时间
     */
    private Date submitTime;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}