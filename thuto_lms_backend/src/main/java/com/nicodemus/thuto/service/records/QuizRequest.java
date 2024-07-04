package com.nicodemus.thuto.service.records;

import java.util.List;

public record QuizRequest (
        Integer id,
        Integer subject_id,
        String quizName
//        List<QuestionRequest> questionList
){
}
