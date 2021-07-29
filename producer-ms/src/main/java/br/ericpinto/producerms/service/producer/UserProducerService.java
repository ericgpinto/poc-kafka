package br.ericpinto.producerms.service.producer;

import br.ericpinto.producerms.model.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserProducerService {
    private static final Logger logger = LoggerFactory.getLogger(UserProducerService.class);
    private final String topic;
    private final KafkaTemplate<String, UserDTO> kafkaTemplate;

    public UserProducerService(@Value("${topic.name}") String topic, KafkaTemplate<String, UserDTO> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(UserDTO userDTO){
        kafkaTemplate.send(topic, userDTO).addCallback(
                success -> logger.info("Messagem send" + success.getProducerRecord().value()),
                failure -> logger.info("Message failure" + failure.getMessage())
        );
    }

}
