package com.nicodemus.thuto.controller;

import com.nicodemus.thuto.model.UserAnswer;
import com.nicodemus.thuto.service.UserAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("userAnswer")
@RequiredArgsConstructor
public class UserAnswerController {
    private final UserAnswerService userAnswerService;

    @PostMapping("/quiz/submit")
    public ResponseEntity<Integer> submitAnswers(
            @RequestBody List<UserAnswer> request,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(userAnswerService.submitAnswers(request, connectedUser));
    }
}
