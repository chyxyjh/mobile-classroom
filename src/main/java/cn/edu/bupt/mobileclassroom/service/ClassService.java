package cn.edu.bupt.mobileclassroom.service;

import cn.edu.bupt.mobileclassroom.repository.ClassRepository;
import cn.edu.bupt.mobileclassroom.repository.QuestionRepository;
import cn.edu.bupt.mobileclassroom.repository.StudentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private StudentClassRepository studentClassRepository;
    @Autowired
    private QuestionRepository questionRepository;

    public Map<String, Object> getClassDetail(Integer classId) {
        return classRepository.getClassDetail(classId);
    }

    public Boolean beginClass(Integer classId) {
        Map classInfo = classRepository.getClassDetail(classId);
        if (classInfo == null) {
            return false;
        }
        studentClassRepository.resetAttendFlag(classId);
        classRepository.setClassBeginFlag(classId, true);
        return true;
    }

    public Boolean endClass(Integer classId) {
        Map classInfo = classRepository.getClassDetail(classId);
        if (classInfo == null) {
            return false;
        }
        classRepository.setClassBeginFlag(classId, false);
        return true;
    }

    public List listAttendStatus(Integer classId) {
        List result = studentClassRepository.listAttendStatus(classId);
        return result;
    }

    public String getClassInfo(Integer classId) {
        String classInfo = classRepository.getClassInfo(classId);
        return classInfo;
    }

    public Boolean setClassInfo(Integer classId, String infoStr) {
        Map classDetail = classRepository.getClassDetail(classId);
        if (classDetail == null) {
            return false;
        }
        classRepository.setClassInfo(classId, infoStr);
        return true;
    }
}
