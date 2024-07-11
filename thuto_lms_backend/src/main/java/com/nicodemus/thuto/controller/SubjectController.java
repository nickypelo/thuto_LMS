package com.nicodemus.thuto.controller;

import com.nicodemus.thuto.model.Subject;
import com.nicodemus.thuto.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<Integer> addSubject(
            @RequestBody Subject request,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(subjectService.save(request, connectedUser));
    }

    @GetMapping()
    public ResponseEntity<List<Subject>> getAllUserSubjects(Authentication connectedUser){
        return ResponseEntity.ok(subjectService.getAllSubjects(connectedUser));
    }

    @GetMapping("/{subject-id}")
    public ResponseEntity<Optional<Subject>> getSubjectById(@PathVariable("subject-id") Integer subjectId){
        return ResponseEntity.ok(subjectService.getSubjectById(subjectId));
    }

    @PutMapping("/name/{subject-id}")
    public ResponseEntity<Integer> updateSubjectName(
            @PathVariable Subject mySubject,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(subjectService.updateSubjectName(mySubject, connectedUser));
    }
}
