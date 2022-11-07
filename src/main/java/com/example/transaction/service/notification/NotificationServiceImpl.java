package com.example.transaction.service.notification;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private static final Logger LOG = LoggerFactory.getLogger(NotificationService.class);
    private static final String TOPIC = "CREDIT_TRANSACTION";
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendEmail(NotificationEvent notificationEvent) {
        LOG.info("Sending Data='{}' to topic='{}' ", notificationEvent.getEmail(), TOPIC);
        Message<String> event = MessageBuilder.withPayload(notificationEvent.getEmail()).setHeader(KafkaHeaders.TOPIC, TOPIC)
                .setHeader(KafkaHeaders.MESSAGE_KEY, "CREDIT_TRANSACTION")
                .build();
        kafkaTemplate.send(event);
    }


}
