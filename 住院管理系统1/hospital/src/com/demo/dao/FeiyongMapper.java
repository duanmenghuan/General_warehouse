package com.demo.dao;

import com.demo.vo.Feiyong;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Feiyong模块的DAO层（数据层）接口，提供增删改查等数据库操作的方法抽象
 */
@Mapper
public interface FeiyongMapper {
    /**
     * 增加费用表记录
     *
     * @param vo
     * @return
     */
    int doCreate(Feiyong vo);

    /**
     * 根据主键id的集合，批量删除对应的费用表记录
     *
     * @param ids
     * @return
     */
    int doRemoveBatch(Collection<Serializable> ids);

    /**
     * 更新费用表记录
     *
     * @param vo
     * @return
     */
    int doUpdate(Feiyong vo);

    /**
     * 根据主键id获取费用表记录的详情
     *
     * @param id
     * @return
     */
    Feiyong findById(Serializable id);

    /**
     * 根据条件查询费用表集合
     *
     * @param params
     * @return
     */
    List<Feiyong> findAllSplit(Map<String, Object> params);

    /**
     * 根据条件查询费用数量
     *
     * @param params
     * @return
     */
    Integer getAllCount(Map<String, Object> params);
}
