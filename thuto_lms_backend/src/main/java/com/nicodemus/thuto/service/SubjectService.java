package com.nicodemus.thuto.service;

import com.nicodemus.thuto.model.Subject;
import com.nicodemus.thuto.model.User;
import com.nicodemus.thuto.repository.SubjectRepository;
import com.nicodemus.thuto.service.mappers.SubjectMapper;
import com.nicodemus.thuto.service.records.SubjectRequest;
import com.nicodemus.thuto.service.response.SubjectResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectMapper subjectMapper;
    private final SubjectRepository subjectRepository;

    public Integer save(SubjectRequest request, Authentication connectedUser){
        User user = ((User) connectedUser.getPrincipal());
        Subject subject = subjectMapper.toSubject(request);
        subject.setUserList(List.of(user));
        return subjectRepository.save(subject).getId();
    }

    public SubjectResponse findById(Integer subjectId) {
        return subjectRepository.findById(subjectId)
                .map(subjectMapper::toSubjectResponse)
                .orElseThrow(()-> new EntityNotFoundException("No Subject of ID " + subjectId + " found!"));
    }
}
