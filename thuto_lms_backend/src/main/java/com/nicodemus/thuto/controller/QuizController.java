package com.nicodemus.thuto.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz")
@RequiredArgsConstructor
@Tag(name = "Quiz")
public class QuizController {
}
