package com.nicodemus.thuto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String subjectName;
    @OneToMany(mappedBy = "subject")
    private List<Topic> topicList;
    @OneToMany(mappedBy = "subject")
    private List<Quiz> quiz;
}
