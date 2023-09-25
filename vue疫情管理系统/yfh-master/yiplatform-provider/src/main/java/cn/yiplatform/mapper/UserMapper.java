package cn.yiplatform.mapper;
import java.util.List;

import cn.yiplatform.entity.Menu;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import cn.yiplatform.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.transaction.annotation.Transactional;

/**
*
* @description 针对表【user(用户表，用来存储用户的基本信息)】的数据库操作Mapper
* @createDate 2022-03-04 23:00:35
* @Entity cn.yiplatform.entity.User
*/
public interface UserMapper extends BaseMapper<User> {

    // 根据账号查询密码
    List<User> selectUserByAccountAndPassword(@Param("account") String account, @Param("password") String password);

    // 根据账号修改密码
    int updatePasswordByAccount(@Param("password") String password, @Param("account") String account);

    // 根据账号查询密码
    List<User> selectPasswordByAccount(@Param("account") String account);

    // 根据用户id查询该用户的菜单列表
    List<Menu> selectUserMenusByUid(Long uid);
}




