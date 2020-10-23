package com.yzc.kafkademo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    public static Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "my-topic";
    private final KafkaTemplate<String, String> template;

    public Producer(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    public void sendMessage(String message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
        this.template.send(TOPIC, message);
    }

}

