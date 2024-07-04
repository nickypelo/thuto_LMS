package com.nicodemus.thuto.controller;

import com.nicodemus.thuto.service.response.SubjectResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.nicodemus.thuto.service.SubjectService;
import com.nicodemus.thuto.service.records.SubjectRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("subject")
@RequiredArgsConstructor
@Tag(name = "Subject")
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<Integer> setSubject(
            @Valid @RequestBody SubjectRequest subjectRequest,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(subjectService.save(subjectRequest, connectedUser));
    }

    @GetMapping("{subject_id}")
    public ResponseEntity<SubjectResponse> findSubjectById(
            @PathVariable("subject_id") Integer subject_id
    ){
        return ResponseEntity.ok(subjectService.findById(subject_id));
    }


}
