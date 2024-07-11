package com.nicodemus.thuto.repository;


import com.nicodemus.thuto.model.Subject;
import com.nicodemus.thuto.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
    Optional<List<Topic>> findAllBySubject(Subject subject);
}
