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
    public void saveTest() {
        LectureFileVO lectureFileVO = new LectureFileVO();
        lectureFileVO.create("테스트4", "2022/12/02", UUID.randomUUID().toString(), 100L, true, 66L);
        lectureFileDAO.save(lectureFileVO);
        log.info("name: " + lectureFileVO.getLectureFileName());
    }

    @Test
    public void deleteTest() {
        lectureFileDAO.remove(174L);
    }

    @Test
    public void selectAllTest() {
        lectureFileDAO.findAll(66L).stream().map(LectureFileVO::getLectureFileName).forEach(log::info);

    }
}