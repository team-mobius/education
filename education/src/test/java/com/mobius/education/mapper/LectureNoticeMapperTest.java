package com.mobius.education.mapper;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.LectureNoticeVO;
import com.mobius.education.domain.vo.LectureVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class LectureNoticeMapperTest {
    @Autowired
    private LectureNoticeMapper lectureNoticeMapper;

    @Test
    public void insertTest() {
        LectureNoticeVO lectureNoticeVO = new LectureNoticeVO();
        lectureNoticeVO.create("[공지] 두번째 공지사항", "두 번째 공지사항입니다.", 97L);
        lectureNoticeMapper.insert(lectureNoticeVO);
        log.info("notice: " + lectureNoticeVO.getLectureNoticeTitle());
    }

    @Test
    public void selectAllTest() {
//        Criteria criteria = new Criteria();
//        criteria.create(1, 10);
//        lectureNoticeMapper.selectAll(9L , criteria).stream().map(LectureNoticeVO::getLectureNoticeTitle).forEach(log::info);
//        log.info("board: " + lectureNoticeMapper.selectAll(9L , criteria));
//        LectureNoticeVO lectureNoticeVO = new LectureNoticeVO();
//        lectureNoticeVO.setLectureNumber(9L);
        lectureNoticeMapper.selectAll(97L , new Criteria().create(1, 10)).stream().map(LectureNoticeVO::getLectureNoticeTitle).forEach(log::info);
    }

    @Test
    public void getTotalTest() {
        log.info("count: " + lectureNoticeMapper.getTotal());
    }

    @Test
    public void selectTest() {
        log.info("select: " + lectureNoticeMapper.select(1L));
    }
}