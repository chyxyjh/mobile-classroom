package cn.edu.bupt.mobileclassroom.dao;

import cn.edu.bupt.mobileclassroom.model.Student;
import cn.edu.bupt.mobileclassroom.model.StudentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    int countByExample(StudentCriteria example);

    int deleteByExample(StudentCriteria example);

    int deleteByPrimaryKey(Integer studentId);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentCriteria example);

    Student selectByPrimaryKey(Integer studentId);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentCriteria example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentCriteria example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}