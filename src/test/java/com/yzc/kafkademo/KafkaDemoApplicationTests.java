package com.yzc.kafkademo;

import com.yzc.kafkademo.web.KafkaController.KafkaController;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class KafkaDemoApplicationTests {

    @Autowired
    private KafkaController controller;

    @Test
    @Ignore
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
