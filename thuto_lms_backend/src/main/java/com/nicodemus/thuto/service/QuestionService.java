package com.nicodemus.thuto.service;

import com.nicodemus.thuto.model.Question;
import com.nicodemus.thuto.model.Subject;
import com.nicodemus.thuto.model.User;
import com.nicodemus.thuto.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public Integer save(List<Question> request, Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());

        if(user.getRoles().contains("student")){
            return 0;
        }
        return questionRepository.saveAll(request).size();
    }

    public List<Question> getAllQuestions(Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());

        return questionRepository.findAllById(
                user.getSubjectList()
                        .stream()
                        .map(Subject::getId)
                        .collect(Collectors.toList()));
    }


    public Optional<Question> getQuestionById(Integer subjectId, Authentication connectedUser) {
        return  questionRepository.findById(subjectId);
    }

    public Integer updateQuestion(Question myQuestion, Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());

        if(user.getRoles().contains("student")){
            return 0;
        }

        Optional<Question> questionOptional = questionRepository.findById(myQuestion.getId());
        Question question = questionOptional.get();
        question.setQuestionSet(myQuestion.getQuestionSet());

        return questionRepository.save(question).getId();
    }

    public Integer updateAnswers(List<Question> myQuestion, Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());

        if(user.getRoles().contains("teacher")){
            return 0;
        }

        return questionRepository.saveAll(myQuestion).size();
    }
}
