package com.nicodemus.thuto.controller;

import com.example.demo.model.Topic;
import com.nicodemus.thuto.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("topics")
@RequiredArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @PostMapping
    public ResponseEntity<Integer> addTopic(
            @RequestBody Topic request,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(topicService.save(request, connectedUser));
    }

    @GetMapping()
    public ResponseEntity<List<Topic>> getAllTopics(Authentication connectedUser){
        return ResponseEntity.ok(topicService.getAllTopics(connectedUser));
    }

    @GetMapping("/{topic-id}")
    public ResponseEntity<Optional<Topic>> getTopicById(@PathVariable("topic-id") Integer topic_Id){
        return ResponseEntity.ok(topicService.getTopicById(topic_Id));
    }


    @PutMapping("/name/{topic-id}")
    public ResponseEntity<Integer> updateTopicName(
            @PathVariable("topic-id")  Topic myTopic,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(topicService.updateTopicName(myTopic, connectedUser));
    }

    @PutMapping("/document/{topic-id}")
    public ResponseEntity<Integer> updatePDF(@PathVariable("topic-id") Topic myTopic){
        return ResponseEntity.ok(topicService.updatePDF(myTopic));
    }

}
