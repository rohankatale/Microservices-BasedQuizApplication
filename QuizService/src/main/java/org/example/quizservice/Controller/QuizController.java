package org.example.quizservice.Controller;


import org.example.quizservice.Model.QuestionWrapper;
import org.example.quizservice.Model.QuizDto;
import org.example.quizservice.Model.Response;
import org.example.quizservice.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto) {

       return quizService.createQuiz(quizDto.getCategoryName(),quizDto.getNumQuestions(),quizDto.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id) {
        return quizService.getQuizQuestions(id);

    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id,@RequestBody List<Response> responses) {
        return quizService.calculateResult(id,responses);
    }

}
