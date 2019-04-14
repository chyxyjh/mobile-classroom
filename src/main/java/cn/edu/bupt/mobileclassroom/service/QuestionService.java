package cn.edu.bupt.mobileclassroom.service;

import cn.edu.bupt.mobileclassroom.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List listQuestions(Integer classId) {
        List result = questionRepository.listQuestions(classId);
        return result;
    }

    public String readQuestion(Integer questionId) {
        String content = questionRepository.getQuestionContent(questionId);
        questionRepository.readQuestion(questionId);
        return content;
    }
}
