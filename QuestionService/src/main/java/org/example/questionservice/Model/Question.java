package org.example.questionservice.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;


@Data
@Entity
@Table(name = "programming_questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('programming_questions_id_seq'")
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficulty;
    private String category;


}
