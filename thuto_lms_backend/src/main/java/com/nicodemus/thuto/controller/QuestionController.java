package com.nicodemus.thuto.controller;

import com.nicodemus.thuto.model.Question;
import com.nicodemus.thuto.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("question")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PutMapping("/edit/{question-id}")
    public ResponseEntity<Integer> updateQuestion(
            @PathVariable("question-id") Question myQuestion,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(questionService.updateQuestion(myQuestion, connectedUser));
    }


}
