package com.yzc.kafkademo.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.yzc.kafkademo.kafka.DemoProducer.MY_TOPIC;

@Component
public class DemoConsumer {
    public static Logger logger = LoggerFactory.getLogger(DemoProducer.class);

    @KafkaListener(topics = MY_TOPIC, groupId = "app1")
    public void consume(ConsumerRecord<String, Object> cr, Consumer<String, Object> consumer) {
        // message id for indempotent consumer
        String id = cr.topic() + "_" + cr.partition() + cr.offset();
        logger.info(String.format("#### -> Consumed message id=%s -> %s", id, cr.toString()));
        logger.info(String.format("topic = %s, partition = %d, offset = %d, key = %s, value = %s%n", cr.topic(), cr.partition(), cr.offset(), cr.key(), cr.value()));
        consumer.commitSync();
    }

}
