package com.nicodemus.thuto.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("question")
@RequiredArgsConstructor
@Tag(name = "Question")
public class QuestionController {

    @GetMapping("/")
    public void bathong(){
        System.out.println("Nicholas");
    }
}
