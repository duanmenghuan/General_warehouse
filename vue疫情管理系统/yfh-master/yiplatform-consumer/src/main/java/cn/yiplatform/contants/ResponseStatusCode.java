package cn.yiplatform.contants;

/**
 *
 * @date 2022/3/8-09:51
 * 定义前端访问接口时，返回的响应状态码
 */
public enum ResponseStatusCode {

    OK("请求成功", "200"),
    NO("请求失败", "409"),

    CREATE("创建成功", "201"),
    DElETED("删除成功", "204"),
    BAD_REQUEST("请求的地址不存在", "400"),
    UNAUTHORIZED("未授权", "401"),
    FORBIDDEN("禁止访问", "403"),
    NOT_FOUND("请求的资源不存在", "404"),
    INTERNAL_SERVER_ERROR("内部错误", "500");

    private String name;
    private String code;

    ResponseStatusCode(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
