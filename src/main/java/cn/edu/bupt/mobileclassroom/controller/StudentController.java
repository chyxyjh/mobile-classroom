package cn.edu.bupt.mobileclassroom.controller;

import cn.edu.bupt.mobileclassroom.service.StudentService;
import cn.edu.bupt.mobileclassroom.util.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/info")
    public HttpResponse getStudentInfo(@RequestParam("student_id") Integer studentId) {
        Map result = studentService.getStudentInfo(studentId);

        return new HttpResponse(result == null ? 204 : 200, result);
    }

    @PostMapping("/attend")
    public HttpResponse attendClass(
            @RequestParam("student_id") Integer studentId,
            @RequestParam("class_id") Integer classId) {
        Boolean result = studentService.attendClass(studentId, classId);
        return new HttpResponse(result ? 200 : 400, result);
    }

    @PostMapping("/question")
    public HttpResponse createQuestion(
            @RequestParam("student_id")Integer studentId,
            @RequestParam("class_id")Integer classId,
            @RequestBody String body) {
        studentService.createQuestion(studentId, classId, body);
        return new HttpResponse(true);
    }

    @GetMapping("/class")
    public HttpResponse listClasses(@RequestParam("student_id") Integer studentId) {
        List result = studentService.listClasses(studentId);
        return new HttpResponse(result);
    }


}
