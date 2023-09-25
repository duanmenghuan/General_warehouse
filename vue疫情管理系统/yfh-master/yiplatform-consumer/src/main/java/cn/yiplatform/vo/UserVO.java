package cn.yiplatform.vo;

import lombok.Data;

/**
 *
 * @date 2022/3/15-14:17
 */
@Data
public class UserVO {

    /**
     * 用户id
     */
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
     * 手机号
     */
    private String mobile;

    /**
     * 用户所在部门中文名
     */
    private String depName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 住址
     */
    private String address;

    /**
     * 今日体温填写状态 0：未填写，1：已填写
     */
    private int fillStatus;
}
