package com.nicodemus.thuto.repository;

import com.nicodemus.thuto.model.Quiz;
import com.nicodemus.thuto.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    Optional<Quiz> findByQuizName(String quizName);
    Optional<List<Quiz>> findAllBySubject(Subject subject);

}
