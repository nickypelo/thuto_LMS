package com.nicodemus.thuto.service;

import com.nicodemus.thuto.model.Subject;
import com.nicodemus.thuto.model.Topic;
import com.nicodemus.thuto.model.User;
import com.nicodemus.thuto.repository.SubjectRepository;
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
    private final SubjectRepository subjectRepository;

    public Integer save(Topic request, Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());

        if(user.getRole().getName().contains("student")){
            return 0;
        }

        if (request.getSubject() == null || request.getSubject().getId() == null) {
            throw new IllegalArgumentException("Subject ID must be provided");
        }

        Optional<Subject> fromRequest = subjectRepository.findByName(request.getSubject().getSubjectName());
        Subject subject = fromRequest.get();
        request.setSubject(subject);

        return topicRepository.save(request).getId();
    }

    public List<Topic> getAllTopics(String mySubject, Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());

        return topicRepository.findAllBySubject(subjectRepository.findByName(mySubject).get()).get();
    }

    public Optional<Topic> getTopicById(Integer topicId) {
        return topicRepository.findById(topicId);
    }

    public Integer updateTopicName(Topic myTopic, Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());

        if (user.getRole().getName().contains("student")) {
            throw new IllegalArgumentException("Student cannot edit this.");
        }

        Topic topic = topicOptionalMapper(myTopic);

        topic.setTopicName(myTopic.getTopicName());
        return topicRepository.save(topic).getId();
    }

    public Integer updatePDF(Topic myTopic) {
        Topic topic = topicOptionalMapper(myTopic);

        return topicRepository.save(topic).getId();
    }

    private Topic topicOptionalMapper(Topic myTopic){
        Optional<Topic> topicOptional = topicRepository.findById(myTopic.getId());

        return topicOptional.get();
    }
}
