package com.nicodemus.thuto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String topicName;
    @ManyToOne
    @JoinColumn(name = "topicList")
    private Subject subject;
}
