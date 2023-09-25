package cn.yiplatform.contants;

/**
 *
 * @date 2022/3/23-14:03
 * 出差记录的审核状态
 */
public enum BusinessRecodeStatusEnum {
    NO_COMMIT("未提交", 0),
    WAIT_AUTH("待审核", 1),
    AUTH_PASS("已通过", 2),
    AUTH_REFUSE("已驳回", 3),
    FINISHED("已归档", 4);

    // 状态名称
    private String statusName;

    // 状态码
    private int statusCode;

    BusinessRecodeStatusEnum(String statusName, int statusCode) {
        this.statusName = statusName;
        this.statusCode = statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
