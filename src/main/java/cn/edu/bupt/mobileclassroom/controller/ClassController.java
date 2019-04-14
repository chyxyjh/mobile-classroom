package cn.edu.bupt.mobileclassroom.controller;

import cn.edu.bupt.mobileclassroom.service.ClassService;
import cn.edu.bupt.mobileclassroom.service.QuestionService;
import cn.edu.bupt.mobileclassroom.service.StudentService;
import cn.edu.bupt.mobileclassroom.util.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/class")
public class ClassController {
    @Autowired
    private ClassService classService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/{class_id}")
    public HttpResponse getClassDetail(@PathVariable("class_id") Integer classId) {
        Map result = classService.getClassDetail(classId);
        return new HttpResponse(result == null ? 404 : 200, result);
    }

    @PostMapping("/{class_id}/begin")
    public HttpResponse beginClass(@PathVariable("class_id") Integer classId) {
        Boolean result = classService.beginClass(classId);
        return new HttpResponse(result ? 200 : 400, result);
    }

    @PostMapping("/{class_id}/end")
    public HttpResponse endClass(@PathVariable("class_id") Integer classId) {
        Boolean result = classService.endClass(classId);
        return new HttpResponse(result ? 200 : 400, result);
    }

    @GetMapping("/{class_id}/attendStatus")
    public HttpResponse listAttendStatus(@PathVariable("class_id") Integer classId) {
        List result = classService.listAttendStatus(classId);
        return new HttpResponse(result);
    }

    @GetMapping("{class_id}/info")
    public HttpResponse getClassInfo(@PathVariable("class_id") Integer classId) {
        String classInfo = classService.getClassInfo(classId);
        return new HttpResponse(classInfo);
    }

    @PostMapping("{class_id}/info")
    public HttpResponse postClassInfo(@PathVariable("class_id") Integer classId, @RequestBody String body) {
        Boolean result = classService.setClassInfo(classId, body);
        return new HttpResponse(result);
    }

}
