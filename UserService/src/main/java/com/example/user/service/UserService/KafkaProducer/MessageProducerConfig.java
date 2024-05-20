package com.example.user.service.UserService.KafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducerConfig {

        @Autowired
        private KafkaTemplate<String, String> kafkaTemplate;

        public void sendMessage(String topic, String message) {
            kafkaTemplate.send(topic, message);
        }


        public void sendMessage1(String topic, String message) {
            kafkaTemplate.send(topic, message);
        }
}
