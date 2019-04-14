package cn.edu.bupt.mobileclassroom.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ClassRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String, Object> getClassDetail(Integer classId) {
        String querySql = String.format("select * from class where class_id = %d", classId);
        List<Map<String, Object>> result = jdbcTemplate.queryForList(querySql);
        if (result == null || result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
    }

    public void setClassBeginFlag(Integer classId, Boolean aimFlag) {
        String sql = String.format("update class set begin_flag = %d where class_id = %d", aimFlag ? 1 : 0, classId);
        jdbcTemplate.execute(sql);
    }

    public String getClassInfo(Integer classId) {
        String sql = String.format("select info from class where class_id = %d", classId);
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
        if (resultList == null || resultList.isEmpty()) {
            return null;
        }
        return resultList.get(0).get("info").toString();
    }

    public void setClassInfo(Integer classId, String classInfo) {
        String sql = String.format("update class set info = %s where class_id = %d", classInfo, classId);
        jdbcTemplate.execute(sql);
    }
}
