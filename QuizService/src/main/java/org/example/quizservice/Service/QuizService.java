package org.example.quizservice.Service;


import org.example.quizservice.Dao.QuizDao;
import org.example.quizservice.Feign.QuizInterface;
import org.example.quizservice.Model.QuestionWrapper;
import org.example.quizservice.Model.Quiz;
import org.example.quizservice.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

      List<Integer> questions = quizInterface.getQuestionsForQuiz(category,numQ).getBody();
      Quiz quiz = new Quiz();
      quiz.setTitle(title);
      quiz.setQuestionsIds(questions);
      quizDao.save(quiz);

        return new ResponseEntity<>("hehe",HttpStatus.CREATED);

    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
       Quiz quiz = quizDao.findById(id).get();
       List<Integer> questionIds = quiz.getQuestionsIds();
       ResponseEntity<List<QuestionWrapper>> questions= quizInterface.getQuestionsFromId(questionIds);
        return questions;
    }

    public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
        ResponseEntity<Integer> score = quizInterface.getScore(responses);
        return score;
    }
}
