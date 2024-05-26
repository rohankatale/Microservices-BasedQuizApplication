package org.example.questionservice.Controller;


import org.example.questionservice.Model.Question;
import org.example.questionservice.Model.QuestionWrapper;
import org.example.questionservice.Model.Response;
import org.example.questionservice.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {

        return questionService.getAllQuestions() ;
    }

    @GetMapping("category/{text}")
    public  ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String text) {

        return questionService.getQuestionByCategory(text);
    }

    @PostMapping("allQuestions")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    // generate
    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName,@RequestParam int numQuestions){

        return questionService.getQuestionsForQuiz(categoryName,numQuestions);

    }
    // getQuestion (question id)
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> ids ) {
        return questionService.getQuestionsFromId(ids);
    }

    // getScore
    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses) {
        return questionService.getScore(responses);
    }

}
