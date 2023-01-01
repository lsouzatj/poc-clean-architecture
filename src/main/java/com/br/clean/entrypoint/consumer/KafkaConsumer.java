package com.br.clean.entrypoint.consumer;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class KafkaConsumer {

    @Value("${topic.name.producer.person}")
    private String topicSendPerson;

    @KafkaListener(topics = "${topic.name.producer.person}", groupId = "${group.name.person}")
    public void consumerPersonOfTopic(String message) {
        log.info("Tópico: {}", topicSendPerson);
        log.info("KafkaConsumer Payload received successfuly. Notificação enviada ao cliente: {}", message);
    }
}
