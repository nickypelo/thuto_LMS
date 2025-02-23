package com.nicodemus.thuto.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String subjectName;

    // relationships
    @OneToMany(mappedBy = "subject")
    private List<Topic> topicList;

    @OneToMany(mappedBy = "subject")
    private List<Quiz> quizList;

    @ManyToMany(mappedBy = "subjectList")
    private List<User> userList;

}
