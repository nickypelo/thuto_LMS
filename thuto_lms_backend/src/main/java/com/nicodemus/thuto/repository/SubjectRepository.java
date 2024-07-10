package com.nicodemus.thuto.repository;

import com.nicodemus.thuto.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    Optional<Subject> findByName(String subjectName);
}
