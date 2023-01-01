package com.br.clean.dataprovider;

import com.br.clean.core.dataprovider.SystemNotification;
import com.br.clean.dataprovider.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SystemNotificationImpl implements SystemNotification {
    private final KafkaProducer kafkaProducer;

    @Override
    public void sendNotification(String message) {
        kafkaProducer.sendPersonToTopic(message);
    }
}
