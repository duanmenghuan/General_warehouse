package com.demo.service;

import com.demo.vo.Zhuyuan;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * Zhuyuan模块的Service层（业务层）接口，提供业务方法的抽象
 */
public interface ZhuyuanService {
    /**
     * 增加住院
     *
     * @param vo
     * @return
     */
    boolean insert(Zhuyuan vo);

    /**
     * 删除住院
     *
     * @param ids
     * @return
     */
    boolean delete(Collection<Serializable> ids);

    /**
     * 修改住院
     *
     * @param vo
     * @return
     */
    boolean update(Zhuyuan vo);

    /**
     * 根据主键Id查询住院详情
     *
     * @param id
     * @return
     */
    Zhuyuan get(Serializable id);

    /**
     * 根据条件查询住院的列表与数量
     *
     * @param params
     * @return
     */
    Map<String, Object> list(Map<String, Object> params);
}
