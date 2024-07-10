package com.nicodemus.thuto.service;

import com.nicodemus.thuto.model.Quiz;
import com.nicodemus.thuto.model.Subject;
import com.nicodemus.thuto.model.User;
import com.nicodemus.thuto.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;

    public Integer save(Quiz request, Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());

        if(user.getRoles().contains("student")){
            return 0;
        }

        return quizRepository.save(request).getId();
    }

    public List<Quiz> getAllQuizzes(Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());

        return quizRepository.findAllById(
                user.getSubjectList()
                        .stream()
                        .map(Subject::getId)
                        .collect(Collectors.toList()));
    }

    public Optional<Quiz> getQuizById(Integer quizId) {
        return quizRepository.findById(quizId);
    }



    public Integer updateQuizName(Quiz myQuiz, Authentication connectedUser) {
        Optional<Quiz> quizOptional = quizRepository.findById(myQuiz.getId());
        Quiz quiz = quizOptional.get();

        quiz.setQuizName(myQuiz.getQuizName());

        return quizRepository.save(quiz).getId();
    }
}
