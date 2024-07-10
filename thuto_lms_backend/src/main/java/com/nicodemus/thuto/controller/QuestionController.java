package com.nicodemus.thuto.controller;

import com.nicodemus.thuto.model.Question;
import com.nicodemus.thuto.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<Integer> addQuestions(
            @RequestBody List<Question> request,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(questionService.save(request, connectedUser));
    }

    @GetMapping()
    public ResponseEntity<List<Question>> getAllQuestions(Authentication connectedUser){
        return ResponseEntity.ok(questionService.getAllQuestions(connectedUser));
    }

    @GetMapping("/{question-id}")
    public ResponseEntity<Optional<Question>> getQuestionById(
            @PathVariable("question-id") Integer subjectId,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(questionService.getQuestionById(subjectId, connectedUser));
    }

    @PutMapping("/{question-id}")
    public ResponseEntity<Integer> updateQuestion(
            @PathVariable("question-id") Question myQuestion,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(questionService.updateQuestion(myQuestion, connectedUser));
    }

    @PutMapping("/answers/all")
    public ResponseEntity<Integer> updateAnswers(
            @PathVariable List<Question> myQuestion,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(questionService.updateAnswers(myQuestion, connectedUser));
    }

}
