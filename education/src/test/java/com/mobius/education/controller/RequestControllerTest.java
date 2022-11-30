package com.mobius.education.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@Slf4j
public class RequestControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void list() throws Exception {
        log.info("request: " + mockMvc.perform(MockMvcRequestBuilders.get("/request/list")).andReturn().getModelAndView().getModelMap());
    }

    @Test
    void ask() throws Exception {
        log.info("flash map: " + mockMvc.perform(MockMvcRequestBuilders.post("/request/ask")
        .param("requestTitle", "글제목 테스트")
        .param("requestContent","글내용 테스트")
        .param("requestCategory","음악")).andReturn().getFlashMap());
    }

//    강의요청 상세보기
    @Test
    void detail() throws Exception {
        log.info("model map:" + mockMvc.perform(MockMvcRequestBuilders.get("/request/detail").param("requestNumber","41"))
        .andReturn().getModelAndView().getModelMap());
    }

}
