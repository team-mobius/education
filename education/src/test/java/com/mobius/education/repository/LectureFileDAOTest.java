package com.mobius.education.repository;

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
class LectureFileDAOTest {
    @Autowired
    private LectureFileDAO lectureFileDAO;

    @Test
    public void insertTest() {
        LectureDTO lectureDTO = new LectureDTO();
        LectureFileVO lectureFileVO = new LectureFileVO();
        lectureDTO.setLectureNumber(26L);
        lectureFileVO.create("테스트dao3", "2022/11/28", UUID.randomUUID().toString(), 100L, lectureDTO.getLectureNumber());
        lectureFileDAO.save(lectureFileVO);
        log.info("name: " + lectureFileVO.getLectureFileName());
    }
}