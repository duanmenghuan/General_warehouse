package cn.yiplatform.service;

import cn.yiplatform.entity.Menu;
import cn.yiplatform.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
*
* @description 针对表【user(用户表，用来存储用户的基本信息)】的数据库操作Service
* @createDate 2022-03-04 17:46:57
*/
@Repository
public interface UserService extends IService<User> {
    /**
     * 用户登录校验
     * @param account
     * @param password
     * @return
     */
    Map<String, Object> authLogin(String account, String password);

    /**
     * 获取用户密码
     * @param account
     * @return
     */
    String getPassword(String account);

    /**
     * 更新密码
     * @param account
     * @param newPassword
     * @return
     */
    Boolean updatePassword(String account, String newPassword);

    /**
     * 修改用户每日体温的填写状态为已填写
     * @param id
     * @return
     */
    Boolean updateFillStatus(Long id);
}
