package cn.yiplatform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户表，用来存储用户的基本信息
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 域账号
     */
    private String account;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 所在部门
     */
//    private Long department;

    /**
     * 用户所在部门中文名
     */
    private String depName;

    /**
     * 用户所在部门英文名
     */
    private String depEnName;

    /**
     * 填写状态，0：未填写，1：已填写
     */
    private Integer fillStatus;

    /**
     * 用户角色id
     */
//    private Long role;

    /**
     * 用户角色名
     */
    private String roleName;

    /**
     * 用户角色英文名
     */
    private String roleEnName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 住址
     */
    private String address;

    /**
     * 逻辑删除标记，0：未删除，1：已删除
     */
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}