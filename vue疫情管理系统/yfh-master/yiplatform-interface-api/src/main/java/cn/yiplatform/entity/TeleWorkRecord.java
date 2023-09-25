package cn.yiplatform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 远程办公记录
 * @TableName tele_work_record
 */
@TableName(value ="tele_work_record")
@Data
public class TeleWorkRecord implements Serializable {
    /**
     * 远程办公记录id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 申请人id
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
     * 开始日期
     */
    private Date startDate;

    /**
     * 结束日期
     */
    private Date endDate;

    /**
     * 申请原因
     */
    private String reason;

    /**
     * 远程办公地点
     */
    private String teleWorkLocation;

    /**
     * 远程办公详细地址
     */
    private String teleWorkLocationDetail;

    /**
     * 提交时间
     */
    private Date submitDate;

    /**
     * 当前状态
     */
    private int status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}