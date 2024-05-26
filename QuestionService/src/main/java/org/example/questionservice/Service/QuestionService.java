package org.example.questionservice.Service;


import org.example.questionservice.Dao.QuestionDao;
import org.example.questionservice.Model.Question;
import org.example.questionservice.Model.QuestionWrapper;
import org.example.questionservice.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
       try {
           return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
       }
       catch (Exception e) {
           e.printStackTrace();
       }
       return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public  ResponseEntity<List<Question>> getQuestionByCategory(String text) {

        try {
            return new ResponseEntity<>(questionDao.findByCategory(text), HttpStatus.OK);
        }
       catch (Exception e) {
            e.printStackTrace();
       }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("Question added", HttpStatus.CREATED);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Question not added", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, int numQuestions) {

        List<Integer> questions = questionDao.findRandomQuestionsByCategory(categoryName,numQuestions);
         return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> ids) {

        List<QuestionWrapper> questionWrappers = new ArrayList<>();
        List<Question> questions = new ArrayList<>();

        for(Integer id : ids) {
            questions.add(questionDao.findById(id).get());
        }
        for(Question question : questions) {
            QuestionWrapper wrapper = new QuestionWrapper();
            wrapper.setId(question.getId());
            wrapper.setQuestionTitle(question.getQuestionTitle());
            wrapper.setOption1(question.getOption1());
            wrapper.setOption2(question.getOption2());
            wrapper.setOption3(question.getOption3());
            wrapper.setOption4(question.getOption4());
            questionWrappers.add(wrapper);
        }
        return new ResponseEntity<>(questionWrappers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {

        int right=0;
        for (Response response : responses) {
            Question question = questionDao.findById(response.getId()).get();
            if (response.getResponse().equals(question.getRightAnswer())){
                right++;
            }
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
