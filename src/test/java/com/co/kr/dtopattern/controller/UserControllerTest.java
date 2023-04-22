package com.co.kr.dtopattern.controller;

import com.co.kr.dtopattern.domain.dto.request.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@WebMvcTest
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createUser() throws Exception {
        UserRequest userRequest = new UserRequest("tester", "tester!@", "tester", 1);
        String content = objectMapper.writeValueAsString(userRequest);
        mvc.perform(post("/api/user")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    void getUser() {
    }

    @Test
    void getUsers() {
    }
}