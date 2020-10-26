package com.yzc.kafkademo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yzc.kafkademo.domain.KeyValue;
import com.yzc.kafkademo.kafka.Producer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@WebMvcTest
public class MockWebApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Producer producer;

    @Test
    public void test() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        KeyValue keyValue = new KeyValue("apple", 12);
        String requestJson = mapper.writeValueAsString(keyValue);
        this.mockMvc
                .perform(post("/kafka/publish").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk());
    }
}
