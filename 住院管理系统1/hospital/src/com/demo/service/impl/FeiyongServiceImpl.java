package com.demo.service.impl;

import com.demo.dao.FeiyongMapper;
import com.demo.service.FeiyongService;
import com.demo.vo.Feiyong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Feiyong模块的Service层（业务层）的具体实现类，对FeiyongService接口中定义的抽象方法作出具体的功能实现
 */
@Service
public class FeiyongServiceImpl implements FeiyongService {

    @Autowired
    private FeiyongMapper feiyongMapper;


    //@Override
    public boolean insert(Feiyong vo) {
        return this.feiyongMapper.doCreate(vo) == 1;
    }

    //@Override
    public boolean delete(Collection<Serializable> ids) {
        return ids.isEmpty() ? false : this.feiyongMapper.doRemoveBatch(ids) == ids.size();
    }

    //@Override
    public boolean update(Feiyong vo) {
        return this.feiyongMapper.doUpdate(vo) == 1;
    }

    //@Override
    public Feiyong get(Serializable id) {
        return this.feiyongMapper.findById(id);
    }

    //@Override
    public Map<String, Object> list(Map<String, Object> params) {
        Map<String, Object> resultMap = new HashMap();
        resultMap.put("totalCount", this.feiyongMapper.getAllCount(params));
        resultMap.put("list", this.feiyongMapper.findAllSplit(params));
        return resultMap;
    }
}
