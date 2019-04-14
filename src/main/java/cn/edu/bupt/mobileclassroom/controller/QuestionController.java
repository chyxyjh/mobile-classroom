package cn.edu.bupt.mobileclassroom.controller;

import cn.edu.bupt.mobileclassroom.service.QuestionService;
import cn.edu.bupt.mobileclassroom.util.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping
    public HttpResponse listQuestions(@RequestParam("class_id") Integer classId) {
        List result = questionService.listQuestions(classId);
        return new HttpResponse(result);
    }

    @PostMapping("/{question_id}")
    public HttpResponse readQuestion(@PathVariable("question_id") Integer questionId) {
        String result = questionService.readQuestion(questionId);
        return new HttpResponse(result == null ? 404 : 200, result);
    }
}
