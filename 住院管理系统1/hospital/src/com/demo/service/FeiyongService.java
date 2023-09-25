package com.demo.service;

import com.demo.vo.Feiyong;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * Feiyong模块的Service层（业务层）接口，提供业务方法的抽象
 */
public interface FeiyongService {
    /**
     * 增加费用
     *
     * @param vo
     * @return
     */
    boolean insert(Feiyong vo);

    /**
     * 删除费用
     *
     * @param ids
     * @return
     */
    boolean delete(Collection<Serializable> ids);

    /**
     * 修改费用
     *
     * @param vo
     * @return
     */
    boolean update(Feiyong vo);

    /**
     * 根据主键Id查询费用详情
     *
     * @param id
     * @return
     */
    Feiyong get(Serializable id);

    /**
     * 根据条件查询费用的列表与数量
     *
     * @param params
     * @return
     */
    Map<String, Object> list(Map<String, Object> params);
}
