package com.yzc.kafkademo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.yzc.kafkademo.kafka.Producer.MY_TOPIC;

@Component
public class Consumer {
    public static Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = MY_TOPIC, groupId = "app1")
    public void consume(ConsumerRecord<?, ?> cr) {
        logger.info(String.format("#### -> Consumed message -> %s", cr.toString()));
        logger.info(String.format("topic = %s, partition = %d, offset = %d, key = %s, value = %s%n", cr.topic(), cr.partition(), cr.offset(), cr.key(), cr.value()));
    }

}
