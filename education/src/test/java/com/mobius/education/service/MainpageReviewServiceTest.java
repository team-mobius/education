package com.mobius.education.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MainpageReviewServiceTest {
    @Autowired
    private ReviewService reviewService;

    @Test
    public void showAllTest() {
        log.info("모든 리뷰:" + reviewService.showAll());
    }
}
