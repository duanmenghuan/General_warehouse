package com.lewis.recruit.mappers;

import com.lewis.recruit.pojo.Position;
import com.lewis.recruit.pojo.StatisticalDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PositionMapper {
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

    @Select("SELECT\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			deliver d\n" +
            "		WHERE\n" +
            "			DATE_FORMAT(d.deliver_date, '%Y') = DATE_FORMAT('2022', '%Y')\n" +
            "	) AS deliverCount,\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			deliver d\n" +
            "		WHERE\n" +
            "			DATE_FORMAT(d.deliver_date, '%Y') = DATE_FORMAT('2022', '%Y')\n" +
            "		AND d.deliver_state = 2\n" +
            "	) AS deliverSuccessCount,\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			position p\n" +
            "		WHERE\n" +
            "			DATE_FORMAT(p.position_release, '%Y') = DATE_FORMAT('2022', '%Y')\n" +
            "	) AS positionCount,\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			position p\n" +
            "		WHERE\n" +
            "			DATE_FORMAT(p.position_release, '%Y') = DATE_FORMAT('2022', '%Y')\n" +
            "		AND p.position_status = 2\n" +
            "	) AS positionSuccessCount,\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			student s\n" +
            "		WHERE\n" +
            "			s.student_employment = 1\n" +
            "	) AS noHaveJobsCount,\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			student s\n" +
            "		WHERE\n" +
            "			s.student_employment = 2\n" +
            "	) AS haveJobsCount\n" +
            "FROM\n" +
            "	DUAL;")
    StatisticalDto getStatisticalByYear(String time);

    @Select("SELECT\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			deliver d\n" +
            "		WHERE\n" +
            "			DATE_FORMAT(d.deliver_date, '%Y%m') = DATE_FORMAT(#{time}, '%Y%m')\n" +
            "	) AS deliverCount,\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			deliver d\n" +
            "		WHERE\n" +
            "			DATE_FORMAT(d.deliver_date, '%Y%m') = DATE_FORMAT(#{time}, '%Y%m')\n" +
            "		AND d.deliver_state = 2\n" +
            "	) AS deliverSuccessCount,\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			position p\n" +
            "		WHERE\n" +
            "			DATE_FORMAT(p.position_release, '%Y%m') = DATE_FORMAT(#{time}, '%Y%m')\n" +
            "	) AS positionCount,\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			position p\n" +
            "		WHERE\n" +
            "			DATE_FORMAT(p.position_release, '%Y%m') = DATE_FORMAT(#{time}, '%Y%m')\n" +
            "		AND p.position_status = 2\n" +
            "	) AS positionSuccessCount,\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			student s\n" +
            "		WHERE\n" +
            "			s.student_employment = 1\n" +
            "	) AS noHaveJobsCount,\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			student s\n" +
            "		WHERE\n" +
            "			s.student_employment = 2\n" +
            "	) AS haveJobsCount\n" +
            "FROM\n" +
            "	DUAL;")
    StatisticalDto getStatisticalByMonth(String time);

    @Select("SELECT\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			deliver d\n" +
            "		WHERE\n" +
            "			DATE_FORMAT(d.deliver_date, '%Y') = DATE_FORMAT('2022', '%Y')\n" +
            "	) AS deliverCount,\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			deliver d\n" +
            "		WHERE\n" +
            "			DATE_FORMAT(d.deliver_date, '%Y') = DATE_FORMAT('2022', '%Y')\n" +
            "		AND d.deliver_state = 2\n" +
            "	) AS deliverSuccessCount,\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			position p\n" +
            "		WHERE\n" +
            "			DATE_FORMAT(p.position_release, '%Y') = DATE_FORMAT('2022', '%Y')\n" +
            "	) AS positionCount,\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			position p\n" +
            "		WHERE\n" +
            "			DATE_FORMAT(p.position_release, '%Y') = DATE_FORMAT('2022', '%Y')\n" +
            "		AND p.position_status = 2\n" +
            "	) AS positionSuccessCount,\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			student s\n" +
            "		WHERE\n" +
            "			s.student_employment = 1\n" +
            "		AND s.student_classg = #{teacherNo}\n" +
            "	) AS noHaveJobsCount,\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			student s\n" +
            "		WHERE\n" +
            "			s.student_employment = 2\n" +
            "		AND s.student_classg = #{teacherNo}\n" +
            "	) AS haveJobsCount\n" +
            "FROM\n" +
            "	DUAL;")
    StatisticalDto getStatisticalByYearT(@Param("time") String time, @Param("teacherNo") String teacherNo);

    @Select("SELECT\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			deliver d\n" +
            "		WHERE\n" +
            "			DATE_FORMAT(d.deliver_date, '%Y%m') = DATE_FORMAT(#{time}, '%Y%m')\n" +
            "	) AS deliverCount,\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			deliver d\n" +
            "		WHERE\n" +
            "			DATE_FORMAT(d.deliver_date, '%Y%m') = DATE_FORMAT(#{time}, '%Y%m')\n" +
            "		AND d.deliver_state = 2\n" +
            "	) AS deliverSuccessCount,\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			position p\n" +
            "		WHERE\n" +
            "			DATE_FORMAT(p.position_release, '%Y%m') = DATE_FORMAT(#{time}, '%Y%m')\n" +
            "	) AS positionCount,\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			position p\n" +
            "		WHERE\n" +
            "			DATE_FORMAT(p.position_release, '%Y%m') = DATE_FORMAT(#{time}, '%Y%m')\n" +
            "		AND p.position_status = 2\n" +
            "	) AS positionSuccessCount,\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			student s\n" +
            "		WHERE\n" +
            "			s.student_employment = 1\n" +
            "		AND s.student_classg = #{teacherNo}\n" +
            "	) AS noHaveJobsCount,\n" +
            "	(\n" +
            "		SELECT\n" +
            "			COUNT(1)\n" +
            "		FROM\n" +
            "			student s\n" +
            "		WHERE\n" +
            "			s.student_employment = 2\n" +
            "		AND s.student_classg = #{teacherNo}\n" +
            "	) AS haveJobsCount\n" +
            "FROM\n" +
            "	DUAL;")
    StatisticalDto getStatisticalByMonthT(@Param("time") String time, @Param("teacherNo") String teacherNo);

    List<Position> getPositionFreshList();

    List<Position> getPositionFreshByKey(String key);
}
