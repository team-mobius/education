package com.mobius.education.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ApplyLectureMapperTest {
    @Autowired
    private ApplyLectureMapper applyLectureMapper;

    @Test
    public void selectTest(){
        log.info("내가 완료한 강좌 :" + applyLectureMapper.selectEndLectureCount(0L));
    }

    @Test
    public void selectTest01(){
        log.info("진행 중인 강좌 :" + applyLectureMapper.selectOnGoingLectureCount(0L));
    }
}
