package cn.yiplatform.controller;

import cn.yiplatform.contants.ResponseStatusCode;
import cn.yiplatform.contants.SysContants;
import cn.yiplatform.dto.UserDTO;
import cn.yiplatform.entity.User;
import cn.yiplatform.service.UserService;
import cn.yiplatform.vo.OperResult;
import cn.yiplatform.vo.UserVO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.*;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 *
 * @date 2022/3/4-18:31
 */
@RestController
@Transactional
@CrossOrigin
public class IndexController {

    @DubboReference(interfaceClass = UserService.class, version = "1.0", check = false, timeout = 1800000000)
    private UserService userService;

    /**
     * 校验登录
     * 返回操作结果
     * @param userDTO
     * @return
     */
    @PostMapping("/login")
    public OperResult authAccount(@RequestBody UserDTO userDTO){
        String account = userDTO.getAccount();
        String password = userDTO.getPassword();
        // 先判断账号或密码是否为空，任一为空则返回失败信息
        if (StringUtils.isEmpty(account)) {
            return new OperResult(OperResult.OPER_FAILURE, "账号不能为空", Boolean.FALSE);
        }
        if (StringUtils.isEmpty(password)) {
            return new OperResult(OperResult.OPER_FAILURE, "密码不能为空", Boolean.FALSE);
        }
        // 获取登录账号的用户相关信息
        Map<String, Object> authLoginResultMap = userService.authLogin(account, password);
        Boolean loginResult = Boolean.FALSE;
        if (MapUtils.isNotEmpty(authLoginResultMap)) {
            loginResult = Boolean.TRUE;
        }
        // 没有此账号的用户信息视为登录失败
        return loginResult ? new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "登录成功", authLoginResultMap)
                : new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(),"登录失败", SysContants.NULL);
    }

    @PostMapping("/updatePassword")
    public OperResult updatePassworByAccount(@RequestBody UserDTO userDTO){
        String account = userDTO.getAccount();
        String newPassword = userDTO.getNewPassword();
        String inputPassword = userDTO.getPassword();

        // 先判断账号或密码是否为空，任一为空则返回失败信息
        if (StringUtils.isEmpty(account)) {
            return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "账号不能为空", Boolean.FALSE);
        }
        if (StringUtils.isEmpty(inputPassword)) {
            return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(),"密码不能为空", Boolean.FALSE);
        }
        if (StringUtils.isEmpty(newPassword)) {
            return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(),"新密码不能为空", Boolean.FALSE);
        }
        String password = userService.getPassword(account);
        if (StringUtils.isEmpty(password)) {
            return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "不存在此用户", Boolean.FALSE);
        }
        if (!StringUtils.equals(password, inputPassword)) {
            return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "原密码错误", Boolean.FALSE);
        }
        // 更新用户密码
        Boolean updateResult = userService.updatePassword(account, newPassword);
        // 返回更新结果
        return updateResult ? new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "密码更新成功", Boolean.TRUE)
                : new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "密码更新失败", Boolean.FALSE);
    }

}
