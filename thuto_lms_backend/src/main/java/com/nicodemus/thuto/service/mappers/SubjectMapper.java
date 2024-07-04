package com.nicodemus.thuto.service.mappers;

import com.nicodemus.thuto.model.Subject;
import com.nicodemus.thuto.model.Topic;
import com.nicodemus.thuto.model.Quiz;
import com.nicodemus.thuto.model.User;
import com.nicodemus.thuto.service.records.SubjectRequest;
import com.nicodemus.thuto.service.response.SubjectResponse;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class SubjectMapper {
    public Subject  toSubject(SubjectRequest request) {
        return Subject.builder()
                .id(request.id())
                .subjectName(request.subjectName())
//                .topicList(convertToEntity(request.topicList()))
//                .quizList(request.quizList())
//                .userList(request.userList())
                .build();
    }

    public SubjectResponse toSubjectResponse(Subject subject) {
        return  SubjectResponse.builder()
                .id(subject.getId())
                .subjectName(subject.getSubjectName())
                .build();
    }
}
