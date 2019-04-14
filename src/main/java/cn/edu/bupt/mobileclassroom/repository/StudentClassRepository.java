package cn.edu.bupt.mobileclassroom.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class StudentClassRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void attendClass(Integer studentId, Integer classId) {
        String exeSql = String.format("update student_class set attend_flag = 1 where student_id = %d and class_id = %d", studentId, classId);
        jdbcTemplate.execute(exeSql);
    }

    public Map<String, Object> getStudentClassInfo(Integer studentId, Integer classId) {
        String querySql = String.format("select * from student_class where student_id = %d and class_id = %d", studentId, classId);
        List<Map<String, Object>> result = jdbcTemplate.queryForList(querySql);
        if (result == null || result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
    }

    public List<Map<String, Object>> listClasses(Integer studentId) {
        String sql = String.format("select * from student_class where student_id = %d", studentId);
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        return result;
    }

    public void resetAttendFlag(Integer classId) {
        String sql = String.format("update student_class set attend_flag = 0 where class_id = %d", classId);
        jdbcTemplate.execute(sql);
    }

    public List<Map<String, Object>> listAttendStatus(Integer classId) {
        String sql = String.format("select * from student_class where class_id = %d", classId);
        return jdbcTemplate.queryForList(sql);
    }
}
