package com.demo.dao;

import com.demo.vo.Drug;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Mapper
public interface DrugMapper {


    Map<String, Object> list(Map<String, Object> params);


    List<Drug> findAllSplit(Map<String, Object> params);

    Integer getAllCount(Map<String, Object> params);

    Drug findById(Serializable id);

    int doCreate(Drug vo);

    int doRemoveBatch(Collection<Serializable> ids);

    int doUpdate(Drug vo);
}
