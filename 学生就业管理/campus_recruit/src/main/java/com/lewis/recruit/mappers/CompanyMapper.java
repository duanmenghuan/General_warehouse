package com.lewis.recruit.mappers;

import com.lewis.recruit.pojo.Company;
import com.lewis.recruit.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CompanyMapper {
    //根据公司账号查询公司信息
    Company getCompanyByComAccount(String companyAccount);

    //添加公司账号
    int saveCompany(Company company);

    //修改公司信息
    int updateCompany(Company company);

    //根据公司id查询公司信息
    Company getCompanyByCompanyId(Integer companyId);

    //修改公司密码
    int updateCompanyPwd(Integer companyId, String salt, String newPassword);

    // 查询所有公司用户信息
    List<Company> getCompanyList();

    //删除公司用户
    int deleteCompany(Integer companyId);

    @Select("select * from company where company_id =#{companyId}")
    Company findCompanyById(Integer companyId);
}
