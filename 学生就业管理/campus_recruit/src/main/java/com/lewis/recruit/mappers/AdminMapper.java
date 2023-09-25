package com.lewis.recruit.mappers;

import com.lewis.recruit.pojo.Admin;
import com.lewis.recruit.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper {
    //根据管理员账号查询管理员信息
    Admin getAdminByAdminAccount(String adminAccount);

    //修改管理员密码
    int updatePwd(Admin admin);

    int saveAdmin(Admin admin);
}
