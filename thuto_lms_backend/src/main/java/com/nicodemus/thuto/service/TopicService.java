package com.nicodemus.thuto.service;

import com.example.demo.model.Topic;
import com.nicodemus.thuto.model.Subject;
import com.nicodemus.thuto.model.User;
import com.nicodemus.thuto.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;

    public Integer save(Topic request, Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());

        if(user.getRoles().contains("student")){
            return 0;
        }
        return topicRepository.save(request).getId();
    }


    public List<Topic> getAllTopics(Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());

        return topicRepository.findAllById(
                user.getSubjectList()
                        .stream()
                        .map(Subject::getId)
                        .collect(Collectors.toList()));
    }

    public Optional<Topic> getTopicById(Integer topicId) {
        return topicRepository.findById(topicId);
    }

    public Integer updateTopicName(Topic myTopic, Authentication connectedUser) {
        Topic topic = topicOptionalMapper(myTopic);

        topic.setTopicName(myTopic.getTopicName());
        return topicRepository.save(topic).getId();
    }

    public Integer updatePDF(Topic myTopic) {
        Topic topic = topicOptionalMapper(myTopic);

        topic.setTopicPDF(myTopic.getTopicPDF());
        return topicRepository.save(topic).getId();
    }

    private Topic topicOptionalMapper(Topic myTopic){
        Optional<Topic> topicOptional = topicRepository.findById(myTopic.getId());

        return topicOptional.get();
    }
}
