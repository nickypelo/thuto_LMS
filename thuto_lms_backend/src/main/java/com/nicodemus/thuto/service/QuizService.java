package com.nicodemus.thuto.service;

import com.nicodemus.thuto.model.Question;
import com.nicodemus.thuto.model.Quiz;
import com.nicodemus.thuto.model.Subject;
import com.nicodemus.thuto.model.User;
import com.nicodemus.thuto.repository.QuestionRepository;
import com.nicodemus.thuto.repository.QuizRepository;
import com.nicodemus.thuto.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;
    private final SubjectRepository subjectRepository;
    private final QuestionRepository questionRepository;

    public Integer save(Quiz request, Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());

        if (user.getRole().getName().contains("student")) {
            return 0;
        }
        if (request.getSubject() == null || request.getSubject().getId() == null) {
            throw new IllegalArgumentException("Subject ID must be provided");
        }

        Subject subject = subjectRepository.findBySubjectName(request.getSubject().getSubjectName())
                .orElseThrow(() -> new IllegalArgumentException("Subject not found"));

        request.setSubject(subject);

        if (request.getQuestionList() != null) {
            for (Question question : request.getQuestionList()) {
                question.setQuiz(request);
            }
            // save your questions in the db
            questionRepository.saveAll(request.getQuestionList());
        }
        return quizRepository.save(request).getId();

    }

    public List<Quiz> getAllQuizzes(String subjectName, Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());

        if (user == null) {
            throw new IllegalArgumentException("User does not exist!");
        }

        Optional<Subject> subjectOptional = subjectRepository.findBySubjectName(subjectName);
        return (quizRepository.findAllBySubject(subjectOptional.get())).get();
    }

    public Optional<Quiz> getQuizById(Integer quizId, Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());

        if (user.getRole().getName().contains("student")) {
            throw new IllegalArgumentException("Student cannot edit this.");
        }

        return  quizRepository.findById(quizId);

    }

    public Integer updateQuizName(Quiz myQuiz, Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());

        if (user == null) {
            throw new IllegalArgumentException("User does not exist!");
        }
        if (user.getRole().getName().contains("student")) {
            throw new IllegalArgumentException("You are not allowed to change anything.");
        }
        Optional<Quiz> quizOptional = quizRepository.findById(myQuiz.getId());
        Quiz quiz = quizOptional.get();
        quiz.setQuizName(myQuiz.getQuizName());

        return quizRepository.save(quiz).getId();
    }
}
