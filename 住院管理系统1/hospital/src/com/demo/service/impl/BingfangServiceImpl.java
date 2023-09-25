package com.demo.service.impl;

import com.demo.dao.BingfangMapper;
import com.demo.service.BingfangService;
import com.demo.vo.Bingfang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Bingfang模块的Service层（业务层）的具体实现类，对BingfangService接口中定义的抽象方法作出具体的功能实现
 */
@Service
public class BingfangServiceImpl implements BingfangService {

    @Autowired
    private BingfangMapper bingfangMapper;


    //@Override
    public boolean insert(Bingfang vo) {
        return this.bingfangMapper.doCreate(vo) == 1;
    }

    //@Override
    public boolean delete(Collection<Serializable> ids) {
        return ids.isEmpty() ? false : this.bingfangMapper.doRemoveBatch(ids) == ids.size();
    }

    //@Override
    public boolean update(Bingfang vo) {
        return this.bingfangMapper.doUpdate(vo) == 1;
    }

    //@Override
    public Bingfang get(Serializable id) {
        return this.bingfangMapper.findById(id);
    }

    //@Override
    public Map<String, Object> list(Map<String, Object> params) {
        Map<String, Object> resultMap = new HashMap();
        resultMap.put("totalCount", this.bingfangMapper.getAllCount(params));
        resultMap.put("list", this.bingfangMapper.findAllSplit(params));
        return resultMap;
    }
}
