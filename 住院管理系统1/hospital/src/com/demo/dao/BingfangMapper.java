package com.demo.dao;

import com.demo.vo.Bingfang;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Bingfang模块的DAO层（数据层）接口，提供增删改查等数据库操作的方法抽象
 */
@Mapper
public interface BingfangMapper {
    /**
     * 增加病房表记录
     *
     * @param vo
     * @return
     */
    int doCreate(Bingfang vo);

    /**
     * 根据主键id的集合，批量删除对应的病房表记录
     *
     * @param ids
     * @return
     */
    int doRemoveBatch(Collection<Serializable> ids);

    /**
     * 更新病房表记录
     *
     * @param vo
     * @return
     */
    int doUpdate(Bingfang vo);

    /**
     * 根据主键id获取病房表记录的详情
     *
     * @param id
     * @return
     */
    Bingfang findById(Serializable id);

    /**
     * 根据条件查询病房表集合
     *
     * @param params
     * @return
     */
    List<Bingfang> findAllSplit(Map<String, Object> params);

    /**
     * 根据条件查询病房数量
     *
     * @param params
     * @return
     */
    Integer getAllCount(Map<String, Object> params);
}
