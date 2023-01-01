package com.br.clean.dataprovider.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class KafkaProducer {

    @Value("${topic.name.producer.person}")
    private String topicSendNetwin;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendPersonToTopic(String message) {
        kafkaTemplate.send(topicSendNetwin, message).addCallback(
                success -> log.info("KafkaProducer Payload send successfuly. {}", success.getProducerRecord().value()),
                failure -> log.error("KafkaProducer Error call:{}", failure.getMessage())
        );
    }
}