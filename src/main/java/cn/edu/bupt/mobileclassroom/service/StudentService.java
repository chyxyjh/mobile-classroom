package cn.edu.bupt.mobileclassroom.service;

import cn.edu.bupt.mobileclassroom.repository.ClassRepository;
import cn.edu.bupt.mobileclassroom.repository.QuestionRepository;
import cn.edu.bupt.mobileclassroom.repository.StudentClassRepository;
import cn.edu.bupt.mobileclassroom.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private StudentClassRepository studentClassRepository;
    @Autowired
    private QuestionRepository questionRepository;

    public Map getStudentInfo(Integer studentId) {
        return studentRepository.getStudentInfo(studentId);
    }

    public Boolean attendClass(Integer studentId, Integer classId) {
        Map studentClassInfo = studentClassRepository.getStudentClassInfo(studentId, classId);
        if (studentClassInfo == null) {
            return false;
        }
        Map<String, Object> classInfo = classRepository.getClassDetail(classId);
        Boolean beginFlag = "1".equals(classInfo.get("begin_flag").toString());
        if (!beginFlag) {
            return false;
        }
        studentClassRepository.attendClass(studentId, classId);
        return true;
    }

    public void createQuestion(Integer studentId, Integer classId, String content) {
        questionRepository.createQuestion(studentId, classId, content);
    }

    public List listClasses(Integer studentId) {
        return studentClassRepository.listClasses(studentId);
    }
}
