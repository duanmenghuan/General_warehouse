package com.lewis.recruit.service;

import com.lewis.recruit.mappers.CompanyMapper;
import com.lewis.recruit.pojo.Company;
import com.lewis.recruit.utils.SaltUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private CompanyMapper companyMapper;

    //通过公司账号查询公司信息
    @Override
    public Company findCompanyByCompanyAccount(String companyAccount) {
        return companyMapper.getCompanyByComAccount(companyAccount);
    }

    //注册公司用户，添加公司用户信息
    @Override
    public int saveCompany(Company company) {
        //随机生成盐
        String salt = SaltUtils.getSalt(4);
        //将盐存入数据
        company.setCompanySalt(salt);
        //将明文密码进行md5 + salt + hash散列
        Md5Hash md5Hash = new Md5Hash(company.getCompanyPassword(), salt, 1024);
        //更换加密后的密码
        company.setCompanyPassword(md5Hash.toHex());
        return companyMapper.saveCompany(company);
    }

    //通过公司id查询公司信息
    @Override
    public Company getCompanyByCompanyId(Integer companyId) {
        return companyMapper.getCompanyByCompanyId(companyId);
    }

    //修改公司信息
    @Override
    public int updateCompany(Company company) {
        return companyMapper.updateCompany(company);
    }

    //验证公司用户输入的旧密码是否正确
    @Override
    public Boolean verifyComPwd(String oldPassword) {
        //获取当前用户
        Company company = (Company) SecurityUtils.getSubject().getPrincipal();
        String salt = company.getCompanySalt();
        Md5Hash md5Hash = new Md5Hash(oldPassword,salt,1024);
        return company.getCompanyPassword().equals(md5Hash.toHex());
    }

    //修改公司用户密码
    @Override
    public int updateCompanyPwd(Company company ,String newPassword) {
        //重新生成盐
        String salt = SaltUtils.getSalt(4);
        //加密
        Md5Hash md5Hash = new Md5Hash(newPassword, salt,1024);
        newPassword = md5Hash.toHex();
        Integer companyId = company.getCompanyId();
        return companyMapper.updateCompanyPwd(companyId, salt, newPassword);
    }

    // 查询所有公司用户信息
    @Override
    public List<Company> getCompanyList() {
        return companyMapper.getCompanyList();
    }

    //删除公司用户
    @Override
    public int deleteCompany(Integer companyId) {
        return companyMapper.deleteCompany(companyId);
    }


    public Company findCompanyById(Integer companyId) {
        return companyMapper.findCompanyById(companyId);
    }
}
