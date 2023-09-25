package com.sjsq.service;

import com.sjsq.pojo.Cars;
import com.sjsq.pojo.Pagination;

public interface CarService {

    /**
     * 添加汽车信息
     *
     * @param c
     * @return
     */
    int addCar(Cars c);

    /**
     * 查找所有汽车信息
     *
     * @param seat
     * @param page
     * @param rows
     * @return
     */
    Pagination<Cars> selAllCar(Integer seat, String page, String rows);

    /**
     * 修改汽车信息
     *
     * @param c
     * @return
     */
    int updCar(Cars c);

    /**
     * 删除汽车信息
     *
     * @param carnumber
     * @return
     */
    int delCar(String carnumber);
}
