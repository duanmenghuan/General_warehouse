package com.mapper;

import com.model.Shangpin;
import com.model.Shangpin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ShangpinMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shangpin
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer shangpinId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shangpin
     *
     * @mbggenerated
     */
    int insert(Shangpin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shangpin
     *
     * @mbggenerated
     */
    Shangpin selectByPrimaryKey(Integer shangpinId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shangpin
     *
     * @mbggenerated
     */
    List<Shangpin> selectAll(@Param("shangpin")Shangpin record,@Param("page")int page,@Param("rows")int rows, @Param("sdate")String sdate, @Param("edate")String edate);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shangpin
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Shangpin record);
}