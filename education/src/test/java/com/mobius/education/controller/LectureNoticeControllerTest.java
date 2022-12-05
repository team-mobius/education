package com.mobius.education.controller;

import com.mobius.education.service.LectureNoticeService;
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
public class LectureNoticeControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void list() throws Exception{
        log.info("boards: " + mockMvc.perform(MockMvcRequestBuilders.get("/lectureBoard/board")).andReturn().getModelAndView().getModelMap());
    }

    @Test
    void read() throws Exception {
        log.info("model map: " + mockMvc.perform(MockMvcRequestBuilders.get("/lectureBoard/read").param("lectureNoticeNumber","2"))
                .andReturn().getModelAndView().getModelMap());
    }
}
