package cn.edu.bupt.mobileclassroom.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map getStudentInfo(Integer studentId) {
        if (studentId == null) {
            return null;
        }
        String sql = "select * from student where student_id = " + studentId;
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        if (list == null || list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }
}
