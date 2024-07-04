package com.nicodemus.thuto.service.records;

public record TopicRequest(
        Integer id,
        String topicName,
        Integer subject_id
) {
}
