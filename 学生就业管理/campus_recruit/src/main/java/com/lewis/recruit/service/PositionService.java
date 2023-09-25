package com.lewis.recruit.service;

import com.lewis.recruit.pojo.Consultation;
import com.lewis.recruit.pojo.Position;
import com.lewis.recruit.pojo.StatisticalDto;

import java.util.List;

public interface PositionService {
    //根据职位id查询职位
    Position getPositionByPositionId(Integer positionId);

    //根据关键字查询职位
    List<Position> getPositionByKey(String key);

    //根据公司id查询职位
    List<Position> getPositionByCompanyId(Integer companyId);

    //查询所有职位信息
    List<Position> getPositionList();

    //发布职位
    int addPosition(Position position);

    //修改职位信息
    int updatePosition(Position position);

    //删除职位信息
    int deletePosition(Integer positionId);

    void auditPosition(Position position);

    List<Position> getPositionYesList();

    StatisticalDto getStatisticalByYear(String time);

    StatisticalDto getStatisticalByMonth(String time);

    List<Position> getPositionFreshList();

    List<Position> getPositionFreshByKey(String key);

}
