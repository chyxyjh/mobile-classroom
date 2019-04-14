package cn.edu.bupt.mobileclassroom.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class QuestionRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createQuestion(Integer studentId, Integer classId, String content) {
        String sql = String.format("insert into question (student_id, class_id, content) values (%d, %d, %s)", studentId, classId, content);
        jdbcTemplate.execute(sql);
    }

    public List<Map<String, Object>> listQuestions(Integer classId) {
        String sql = String.format("select * from question where class_id = %d", classId);
        return jdbcTemplate.queryForList(sql);
    }

    public String getQuestionContent(Integer questionId) {
        String sql = String.format("select content from question where question_id = %d", questionId);
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        if (result == null || result.isEmpty()) {
            return null;
        } else {
            return result.get(0).get("content").toString();
        }
    }

    public void readQuestion(Integer questionId) {
        String sql = String.format("update question set has_read = 1 where question_id = %d", questionId);
        jdbcTemplate.execute(sql);
    }
}
