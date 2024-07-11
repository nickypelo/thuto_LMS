package com.nicodemus.thuto.service;

import com.nicodemus.thuto.model.User;
import com.nicodemus.thuto.model.UserAnswer;
import com.nicodemus.thuto.repository.UserAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAnswerService {
    private final UserAnswerRepository userAnswerRepository;

    public Integer submitAnswers(List<UserAnswer> request, Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());

        if(user.getRole().getName().contains("student")){
            throw new IllegalStateException("Teacher cannot answer student questions!");
        }

        return userAnswerRepository.saveAll(request).size();
    }
}
