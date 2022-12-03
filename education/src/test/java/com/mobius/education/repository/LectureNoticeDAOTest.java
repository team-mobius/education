package com.mobius.education.repository;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.LectureNoticeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class LectureNoticeDAOTest {
    @Autowired
    private LectureNoticeDAO lectureNoticeDAO;

    @Test
    public void saveTest() {
        LectureNoticeVO lectureNoticeVO = new LectureNoticeVO();
        lectureNoticeVO.create("[공지] 강의 공지 DAO test 1", "강의 공지 dao test입니다.", 9L);
        lectureNoticeDAO.save(lectureNoticeVO);
        log.info("lecture: " + lectureNoticeVO.getLectureNoticeTitle());
    }

    @Test
    public void findAllTest() {
        lectureNoticeDAO.findAll(97L ,new Criteria().create(1, 20)).stream().map(LectureNoticeVO::getLectureNoticeTitle).forEach(log::info);
    }

    @Test
    public void countTotalTest() {
        log.info("count: " + lectureNoticeDAO.countTotal());
    }

    @Test
    public void findByIdTest() {
        log.info("select: " + lectureNoticeDAO.findById(1L));
    }
}