package com.mobius.education.mapper;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.LectureDTO;
import com.mobius.education.domain.vo.LectureFileVO;
import com.mobius.education.domain.vo.LectureVO;
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
        lectureFileVO.create("테스트2", "2022/12/02", UUID.randomUUID().toString(), 100L, true, 65L);
        lectureFileMapper.insert(lectureFileVO);
        log.info("name: " + lectureFileVO.getLectureFileName());
    }

    @Test
    public void deleteTest() {
        lectureFileMapper.delete(65L);
    }

    @Test
    public void selectAllTest() {
        lectureFileMapper.selectAll(97L).stream().map(LectureFileVO::getLectureFileName).forEach(log::info);

    }

}