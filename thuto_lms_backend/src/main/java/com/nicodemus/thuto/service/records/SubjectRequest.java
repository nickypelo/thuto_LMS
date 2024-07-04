package com.nicodemus.thuto.service.records;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record SubjectRequest(
        Integer id,
        @NotEmpty(message = "100")
        @NotNull(message = "100")
        String subjectName

//        List<TopicRequest> topicList,
//        List<QuizRequest> quizList,
//        List<UserRequest> userList
) {
}
