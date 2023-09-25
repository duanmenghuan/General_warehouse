package com.sjsq.service.impl;

import com.sjsq.mapper.CarMapper;
import com.sjsq.pojo.Cars;
import com.sjsq.pojo.Pagination;
import com.sjsq.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public int addCar(Cars c) {
        return carMapper.addCar(c);
    }

    @Override
    public Pagination<Cars> selAllCar(Integer seat, String page, String rows) {
        int p = Integer.parseInt(page);
        int r = Integer.parseInt(rows);
        List<Cars> list = carMapper.selAllCar(seat, (p - 1) * r, r);
        int total = carMapper.selCountCar();
        Pagination<Cars> pt = new Pagination<>();
        pt.setRows(list);
        pt.setTotal(total);
        return pt;
    }

    @Override
    public int updCar(Cars c) {
        return carMapper.updCar(c);
    }

    @Override
    public int delCar(String carnumber) {
        return carMapper.delCar(carnumber);
    }
}
