package com.lewis.recruit.service;

import com.lewis.recruit.mappers.PositionMapper;
import com.lewis.recruit.pojo.Position;
import com.lewis.recruit.pojo.StatisticalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private DeliverServiceImpl deliverService;

    //通过职位信息id查询职位信息
    @Override
    public Position getPositionByPositionId(Integer positionId) {
        return positionMapper.getPositionByPositionId(positionId);
    }

    //根据关键字查询职位信息
    @Override
    public List<Position> getPositionByKey(String key) {
        return positionMapper.getPositionByKey(key);
    }

    //查询公司的所有职位信息
    @Override
    public List<Position> getPositionByCompanyId(Integer companyId) {
        List<Position> positionList = positionMapper.getPositionByCompanyId(companyId);
        //遍历职位集合，把每个职位简历投递次数存入position对象
        for (Position position : positionList) {
            Integer positionId = position.getPositionId();
            int deliverCount = deliverService.deliverResumeCount(positionId);
            position.setDeliverCount(deliverCount);
        }
        return positionList;
    }

    //查询所有的职位信息
    @Override
    public List<Position> getPositionList() {
        return positionMapper.getPositionList();
    }

    //发布职位信息
    @Override
    public int addPosition(Position position) {
        return positionMapper.addPosition(position);
    }

    //修改发布的职位信息
    @Override
    public int updatePosition(Position position) {
        return positionMapper.updatePosition(position);
    }

    //删除已发布的职位信息
    @Override
    public int deletePosition(Integer positionId) {
        return positionMapper.deletePosition(positionId);
    }

    @Override
    public void auditPosition(Position position) {
        positionMapper.auditPosition(position);
    }

    @Override
    public List<Position> getPositionYesList() {
        return positionMapper.getPositionYesList();
    }

    @Override
    public StatisticalDto getStatisticalByYear(String time) {
        return positionMapper.getStatisticalByYear(time);
    }

    @Override
    public StatisticalDto getStatisticalByMonth(String time) {
        return positionMapper.getStatisticalByMonth(time);
    }

    @Override
    public List<Position> getPositionFreshList() {
        return positionMapper.getPositionFreshList();
    }

    @Override
    public List<Position> getPositionFreshByKey(String key) {
        return positionMapper.getPositionFreshByKey(key);
    }

    public StatisticalDto getStatisticalByYearT(String time, String teacherNo) {
        return positionMapper.getStatisticalByYearT(time,teacherNo);
    }

    public StatisticalDto getStatisticalByMonthT(String time, String teacherNo) {
        return positionMapper.getStatisticalByMonthT(time, teacherNo);
    }
}
