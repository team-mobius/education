package com.mobius.education.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ReviewMapperTest {
    @Autowired
    private ReviewMapper reviewMapper;

    @Test
    public void selectUserReviewTest(){
        log.info("나의 리뷰 수: " + reviewMapper.selectUserReviewCount(0L));
    }

    @Test
    public void selectMyAllReviewTest(){
        log.info("asd"+reviewMapper.selectAllMyReview(0L));
    }

    @Test
    public void selectAllTest(){
        log.info("전체 리뷰 조회: " + reviewMapper.selectAll());
    }
}
