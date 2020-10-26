package com.yzc.kafkademo.web.KafkaController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yzc.kafkademo.domain.KeyValue;
import com.yzc.kafkademo.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * curl -X POST -F 'message=test' http://localhost:9000/kafka/publish
 * curl -X POST -H "Content-Type: application/json"  -d '{"key":"apple", "value": 12}' http://localhost:9000/kafka/publish
 */
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(path = "/publish", consumes = "application/json")
    public void sendMessageToKafkaTopic(@RequestBody String jsonStr) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        KeyValue keyValue = objectMapper.readValue(jsonStr, KeyValue.class);
        this.producer.sendKeyValue(keyValue);
    }
}
