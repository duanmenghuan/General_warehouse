package com.sjsq.mapper;

import com.sjsq.pojo.Menus;

import java.util.List;
import java.util.Map;

public interface MenuMapper {

    List<Menus> selByRidPid(Map<String, Object> map);
}
