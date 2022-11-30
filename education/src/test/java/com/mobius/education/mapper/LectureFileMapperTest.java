package com.mobius.education.mapper;

import com.mobius.education.domain.vo.LectureDTO;
import com.mobius.education.domain.vo.LectureFileVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class LectureFileMapperTest {

    @Autowired
    private LectureFileMapper lectureFileMapper;

    @Test
    public void insertTest() {
        LectureFileVO lectureFileVO = new LectureFileVO();
        lectureFileVO.create("테스트3", "2022/11/28", UUID.randomUUID().toString(), 100L, 26L);
        lectureFileMapper.insert(lectureFileVO);
        log.info("name: " + lectureFileVO.getLectureFileName());
    }

}