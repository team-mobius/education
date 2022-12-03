package com.mobius.education.service;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.LectureNoticeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class LectureNoticeServiceTest {
    @Autowired
    private LectureNoticeService lectureNoticeService;

    @Test
    public void saveTest() {
        LectureNoticeVO lectureNoticeVO = new LectureNoticeVO();
        lectureNoticeVO.create("[공지] 강의 공지 서비스 테스트 1", "강의 공지 서비스 테스트입니다.", 9L);
        lectureNoticeService.save(lectureNoticeVO);
        log.info("save : " + lectureNoticeVO.getLectureNoticeTitle());
    }

    @Test
    public void showAllTest() {
        lectureNoticeService.showAll(97L, new Criteria().create(1, 20)).stream().map(LectureNoticeVO::getLectureNoticeTitle).forEach(log::info);

    }

    @Test
    public void countAllTest() {
        log.info("count: " + lectureNoticeService.countAll());
    }

    @Test
    public void showTest() {
        log.info("find: " + lectureNoticeService.show(1L));
    }
}