package com.demo.service;

import com.demo.vo.Bingfang;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * Bingfang模块的Service层（业务层）接口，提供业务方法的抽象
 */
public interface BingfangService {
    /**
     * 增加病房
     *
     * @param vo
     * @return
     */
    boolean insert(Bingfang vo);

    /**
     * 删除病房
     *
     * @param ids
     * @return
     */
    boolean delete(Collection<Serializable> ids);

    /**
     * 修改病房
     *
     * @param vo
     * @return
     */
    boolean update(Bingfang vo);

    /**
     * 根据主键Id查询病房详情
     *
     * @param id
     * @return
     */
    Bingfang get(Serializable id);

    /**
     * 根据条件查询病房的列表与数量
     *
     * @param params
     * @return
     */
    Map<String, Object> list(Map<String, Object> params);
}
