package com.demo.service.impl;

import com.demo.dao.DrugMapper;
import com.demo.service.DrugService;
import com.demo.util.Util;
import com.demo.vo.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class DrugServiceImpl  implements DrugService {

    @Autowired
    private DrugMapper drugMapper;

    @Override
    public Map<String, Object> list(Map<String, Object> params) {
        Map<String, Object> resultMap = new HashMap();
        resultMap.put("totalCount", this.drugMapper.getAllCount(params));
        resultMap.put("list", this.drugMapper.findAllSplit(params));
        return resultMap;
    }

    @Override
    public Drug get(Serializable id) {
        return this.drugMapper.findById(id);
    }

    @Override
    public boolean insert(Drug vo) {
        return this.drugMapper.doCreate(vo) == 1;
    }

    @Override
    public boolean delete(Collection<Serializable> ids) {
        return ids.isEmpty() ? false : this.drugMapper.doRemoveBatch(ids) == ids.size();
    }

    @Override
    public boolean update(Drug vo) {
        return this.drugMapper.doUpdate(vo) == 1;
    }


}
