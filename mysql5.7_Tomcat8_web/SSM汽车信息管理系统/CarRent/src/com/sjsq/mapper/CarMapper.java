package com.sjsq.mapper;

import com.sjsq.pojo.Cars;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CarMapper {

    //添加汽车信息
    @Insert("insert into Cars values(#{carnumber},#{cartype},#{color},#{rentprice},#{deposit},#{isrenting},#{cardesc},#{carimg},#{seat})")
    int addCar(Cars c);

    //查询所有汽车
    List<Cars> selAllCar(@Param("seat") Integer seat, @Param("start") int start, @Param("size") int size);

    //查询汽车总数
    @Select("select count(*) from cars")
    int selCountCar();

    //修改汽车信息
    @Update("update cars set cartype=#{cartype},color=#{color},rentprice=#{rentprice},deposit=#{deposit},isrenting=#{isrenting},cardesc=#{cardesc},seat=#{seat} where carnumber=#{carnumber}")
    int updCar(Cars c);

    //删除汽车信息
    @Delete("delete from cars where carnumber=#{carnumber}")
    int delCar(@Param("carnumber") String carnumber);
}
