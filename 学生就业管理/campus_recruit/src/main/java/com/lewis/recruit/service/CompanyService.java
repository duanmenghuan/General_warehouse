package com.lewis.recruit.service;

import com.lewis.recruit.pojo.Company;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CompanyService {
    //根据公司账号查询公司信息
    Company findCompanyByCompanyAccount(String companyAccount);

    //添加公司账号
    int saveCompany(Company company);

    //根据公司id查询公司信息
    Company getCompanyByCompanyId(Integer companyId);

    //修改公司信息
    int updateCompany(Company company);

    //修改密码时验证公司旧密码
    Boolean verifyComPwd(String oldPassword);

    //修改公司密码
    int updateCompanyPwd(Company company, String newPassword);

    // 查询所有公司用户信息
    List<Company> getCompanyList();

    //删除公司用户
    int deleteCompany(Integer companyId);
}
