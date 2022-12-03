package com.mobius.education.repository;

import com.mobius.education.domain.vo.LectureFileVO;
import com.mobius.education.domain.vo.LectureThumbnailVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
@Slf4j
class LectureThumbnailDAOTest {
    @Autowired
    private LectureThumbnailDAO lectureThumbnailDAO;

    @Test
    public void saveTest() {
        LectureThumbnailVO lectureThumbnailVO = new LectureThumbnailVO();
        lectureThumbnailVO.create("썸네일dao2", "2022/12/03", UUID.randomUUID().toString(), 200L, true, 125L);
        lectureThumbnailDAO.save(lectureThumbnailVO);
        log.info("name: " + lectureThumbnailVO.getLectureThumbnailName());
    }

    @Test
    public void deleteTest() {
        lectureThumbnailDAO.remove(125L);
    }

    @Test
    public void selectAllTest() {
        lectureThumbnailDAO.findAll(125L).stream().map(LectureThumbnailVO::getLectureThumbnailName).forEach(log::info);

    }
}