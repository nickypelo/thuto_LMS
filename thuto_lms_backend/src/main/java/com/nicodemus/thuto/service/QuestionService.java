package com.nicodemus.thuto.service;

import com.nicodemus.thuto.model.Question;
import com.nicodemus.thuto.model.User;
import com.nicodemus.thuto.repository.QuestionRepository;
import com.nicodemus.thuto.repository.UserAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final UserAnswerRepository userAnswerRepository;

    public Integer updateQuestion(Question myQuestion, Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());

        if(user.getRole().getName().contains("student")){
            throw new IllegalArgumentException("You are not authorised to edit this question.");
        }

        Optional<Question> questionOptional = questionRepository.findById(myQuestion.getId());
        Question question = questionOptional.get();
        question.setQuestionSet(myQuestion.getQuestionSet());

        return questionRepository.save(question).getId();
    }
}
