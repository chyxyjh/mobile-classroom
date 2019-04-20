package cn.edu.bupt.mobileclassroom.dao;

import cn.edu.bupt.mobileclassroom.model.Question;
import cn.edu.bupt.mobileclassroom.model.QuestionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionMapper {
    int countByExample(QuestionCriteria example);

    int deleteByExample(QuestionCriteria example);

    int deleteByPrimaryKey(Integer questionId);

    int insert(Question record);

    int insertSelective(Question record);

    List<Question> selectByExample(QuestionCriteria example);

    Question selectByPrimaryKey(Integer questionId);

    int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionCriteria example);

    int updateByExample(@Param("record") Question record, @Param("example") QuestionCriteria example);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
}