package com.demo.service.impl;

import com.demo.dao.ZhuyuanMapper;
import com.demo.service.ZhuyuanService;
import com.demo.vo.Zhuyuan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Zhuyuan模块的Service层（业务层）的具体实现类，对ZhuyuanService接口中定义的抽象方法作出具体的功能实现
 */
@Service
public class ZhuyuanServiceImpl implements ZhuyuanService {

    @Autowired
    private ZhuyuanMapper zhuyuanMapper;


    //@Override
    public boolean insert(Zhuyuan vo) {
        return this.zhuyuanMapper.doCreate(vo) == 1;
    }

    //@Override
    public boolean delete(Collection<Serializable> ids) {
        return ids.isEmpty() ? false : this.zhuyuanMapper.doRemoveBatch(ids) == ids.size();
    }

    //@Override
    public boolean update(Zhuyuan vo) {
        return this.zhuyuanMapper.doUpdate(vo) == 1;
    }

    //@Override
    public Zhuyuan get(Serializable id) {
        return this.zhuyuanMapper.findById(id);
    }

    //@Override
    public Map<String, Object> list(Map<String, Object> params) {
        Map<String, Object> resultMap = new HashMap();
        resultMap.put("totalCount", this.zhuyuanMapper.getAllCount(params));
        resultMap.put("list", this.zhuyuanMapper.findAllSplit(params));
        return resultMap;
    }
}
