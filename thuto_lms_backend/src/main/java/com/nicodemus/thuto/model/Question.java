package com.nicodemus.thuto.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Question {

    private Integer id;
    private String questionSet;
    private String answerProvided;
    private String answerSet;
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
