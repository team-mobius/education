package com.mobius.education.mapper;

import com.mobius.education.domain.vo.LectureFileVO;
import com.mobius.education.domain.vo.LectureThumbnailVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
@Slf4j
class LectureThumbnailMapperTest {

    @Autowired
    private LectureThumbnailMapper lectureThumbnailMapper;

    @Test
    public void insertTest() {
        LectureThumbnailVO lectureThumbnailVO = new LectureThumbnailVO();
        lectureThumbnailVO.create("썸네일1", "2022/12/03", UUID.randomUUID().toString(), 100L, true, 125L);
        lectureThumbnailMapper.insert(lectureThumbnailVO);
        log.info("name: " + lectureThumbnailVO.getLectureThumbnailName());
    }

    @Test
    public void deleteTest() {
        lectureThumbnailMapper.delete(125L);
    }

    @Test
    public void selectAllTest() {
        lectureThumbnailMapper.selectAll(125L);
    }

}