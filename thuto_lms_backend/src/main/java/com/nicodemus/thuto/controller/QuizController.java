package com.nicodemus.thuto.controller;


import com.nicodemus.thuto.model.Quiz;
import com.nicodemus.thuto.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("quiz")
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @PostMapping
    public ResponseEntity<Integer> addQuiz(
            @RequestBody Quiz request,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(quizService.save(request, connectedUser));
    }

    @GetMapping()
    public ResponseEntity<List<Quiz>> getAllTopics(Authentication connectedUser){
        return ResponseEntity.ok(quizService.getAllQuizzes( connectedUser));
    }

    @GetMapping("/{student-id}")
    public ResponseEntity<Optional<Quiz>> getQuizById(
            @PathVariable("student-id") Integer quiz_id,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(quizService.getQuizById(quiz_id, connectedUser));
    }

    @PutMapping("/update/{student-id}")
    public ResponseEntity<Integer> updateQuizName(
            @PathVariable("student-id") Quiz myQuiz,
            Authentication connectedUser
            ){
        return ResponseEntity.ok(quizService.updateQuizName(myQuiz, connectedUser));
    }
}
