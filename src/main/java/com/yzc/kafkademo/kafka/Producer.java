package com.yzc.kafkademo.kafka;

import com.yzc.kafkademo.domain.KeyValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    public static Logger logger = LoggerFactory.getLogger(Producer.class);
    public static final String MY_TOPIC = "my-topic";
    private final KafkaTemplate<String, Object> template;

    public Producer(KafkaTemplate<String, Object> template) {
        this.template = template;
    }

    public void sendKeyValue(KeyValue keyValue) {
        logger.info(String.format("#### -> Producing message -> %s", keyValue));
        template.send(MY_TOPIC, keyValue.getKey(), keyValue.getValue());
    }

}

