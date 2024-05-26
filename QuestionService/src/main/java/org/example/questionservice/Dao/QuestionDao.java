package org.example.questionservice.Dao;


import org.example.questionservice.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {


    List<Question> findByCategory(String text);

    @Query(value = "SELECT id FROM  programming_questions q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int numQ);
}
