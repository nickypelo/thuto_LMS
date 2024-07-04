package com.nicodemus.thuto.repository;

import com.nicodemus.thuto.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
