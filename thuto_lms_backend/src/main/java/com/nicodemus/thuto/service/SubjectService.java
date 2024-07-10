package com.nicodemus.thuto.service;

import com.nicodemus.thuto.model.Subject;
import com.nicodemus.thuto.model.User;
import com.nicodemus.thuto.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public Integer save(Subject request, Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());

        if(user.getRoles().contains("student")){
            return 0;
        }

        return subjectRepository.save(request).getId();
    }

    public List<Subject> getAllSubjects(Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());

        return subjectRepository.findAllById(
                user.getSubjectList()
                        .stream()
                        .map(Subject::getId)
                        .collect(Collectors.toList()));
    }

    public Optional<Subject> getSubjectById(Integer subjectId) {
        return subjectRepository.findById(subjectId);
    }

    public Integer updateSubjectName(Subject mySubject, Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());

        if(user.getRoles().contains("student")){
            return 0;
        }

        Optional<Subject> subjectOptional = subjectRepository.findById(mySubject.getId());
        Subject subject = subjectOptional.get();
        subject.setSubjectName(mySubject.getSubjectName());

        return subjectRepository.save(subject).getId();
    }
}
