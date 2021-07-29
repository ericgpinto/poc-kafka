package br.ericpinto.consumerms.consumer;

import br.ericpinto.consumerms.model.UserDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {

    private static final Logger log = LoggerFactory.getLogger(UserConsumer.class);

    @Value(value = "${topic.name}")
    private String topic;

    @Value(value = "${spring.kafka.group-id}")
    private String groupId;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "userKafkaListenerContainerFactory")
    public void listenTopicUser(ConsumerRecord<String, UserDTO> record){
        log.info("Received Message " + record.partition());
        log.info("Received Message " + record.value());
    }

}