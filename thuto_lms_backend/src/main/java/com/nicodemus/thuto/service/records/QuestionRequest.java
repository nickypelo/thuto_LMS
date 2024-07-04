package com.nicodemus.thuto.service.records;

public record QuestionRequest(
        Integer id,
        String questionSet,
        String answerProvided,
        String answerSet,
        Integer quiz_id
) {
}
