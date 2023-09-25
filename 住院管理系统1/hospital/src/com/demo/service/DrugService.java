package com.demo.service;

import com.demo.vo.Drug;
import com.demo.vo.User;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DrugService {

    /**
     * ����������ѯ�û����б�������
     *
     * @param params
     * @return
     */
    Map<String, Object> list(Map<String, Object> params);

    Drug get(Serializable id);

    boolean insert(Drug vo);

    boolean delete(Collection<Serializable> ids);

    boolean update(Drug vo);
}
