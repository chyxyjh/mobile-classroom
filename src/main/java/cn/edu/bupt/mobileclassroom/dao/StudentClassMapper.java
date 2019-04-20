package cn.edu.bupt.mobileclassroom.dao;

import cn.edu.bupt.mobileclassroom.model.StudentClass;
import cn.edu.bupt.mobileclassroom.model.StudentClassCriteria;
import cn.edu.bupt.mobileclassroom.model.StudentClassKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentClassMapper {
    int countByExample(StudentClassCriteria example);

    int deleteByExample(StudentClassCriteria example);

    int deleteByPrimaryKey(StudentClassKey key);

    int insert(StudentClass record);

    int insertSelective(StudentClass record);

    List<StudentClass> selectByExample(StudentClassCriteria example);

    StudentClass selectByPrimaryKey(StudentClassKey key);

    int updateByExampleSelective(@Param("record") StudentClass record, @Param("example") StudentClassCriteria example);

    int updateByExample(@Param("record") StudentClass record, @Param("example") StudentClassCriteria example);

    int updateByPrimaryKeySelective(StudentClass record);

    int updateByPrimaryKey(StudentClass record);
}