package cn.edu.bupt.mobileclassroom.dao;

import cn.edu.bupt.mobileclassroom.model.ClassObj;
import cn.edu.bupt.mobileclassroom.model.ClassObjCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassObjMapper {
    int countByExample(ClassObjCriteria example);

    int deleteByExample(ClassObjCriteria example);

    int deleteByPrimaryKey(Integer classId);

    int insert(ClassObj record);

    int insertSelective(ClassObj record);

    List<ClassObj> selectByExample(ClassObjCriteria example);

    ClassObj selectByPrimaryKey(Integer classId);

    int updateByExampleSelective(@Param("record") ClassObj record, @Param("example") ClassObjCriteria example);

    int updateByExample(@Param("record") ClassObj record, @Param("example") ClassObjCriteria example);

    int updateByPrimaryKeySelective(ClassObj record);

    int updateByPrimaryKey(ClassObj record);
}