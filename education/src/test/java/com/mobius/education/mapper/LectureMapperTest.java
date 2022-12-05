package com.mobius.education.mapper;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.LectureDTO;
import com.mobius.education.domain.vo.LectureVO;
import com.mobius.education.domain.vo.ReviewDTO;
import com.mobius.education.domain.vo.TeacherVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class LectureMapperTest {

    @Autowired
    private LectureMapper lectureMapper;

//    강의 추가
    @Test
    public void insertTest(){
        LectureDTO lectureDTO = new LectureDTO();
        lectureDTO.create("중학교 2학년에 맞춘 직독직해 영문법 3800제", "언어", "이 강의를 통해 영어 어순대로 한글 해석 하는 법을 배우면 영어가 정말 쉽구나 라는 것을 느끼실 겁니다.",
                "2022-12-20", 24L, "Time A (9:00~12:00)", "뫼비우스강연장 5F 501","진행예정", 1L, 2L);
        lectureMapper.insert(lectureDTO);
        log.info("number: " + lectureDTO.getLectureNumber());
        log.info("title: " + lectureDTO.getLectureTitle());
        log.info("category: " + lectureDTO.getLectureCategory());
    }

    @Test
    public void deleteTest() {
        LectureVO lectureVO = new LectureVO();
        lectureMapper.delete(219L);
    }

    @Test
    public void lectureSelectAllTest(){
        Long teacherNumber = 2L;
        lectureMapper.finishedSelectAll(new Criteria().create(1, 10), teacherNumber).stream().map(LectureVO::getLectureTitle).forEach(log::info);
    }

    @Test
    public void finishedSelectTotalTest() {
        lectureMapper.finishedGetTotal(2L);
    }

    @Test
    public void ongoingSelectAllTest(){
        lectureMapper.ongoingSelectAll(new Criteria().create(1, 10), 2L).stream().map(LectureVO::getLectureTitle).forEach(log::info);
    }

    @Test
    public void expectedSelectAllTest(){
        lectureMapper.expectedSelectAll(new Criteria().create(1, 10), 2L).stream().map(LectureVO::getLectureTitle).forEach(log::info);
    }

    @Test
    public void selectAllTest() {
        lectureMapper.selectAll(new Criteria().create(3, 10)).stream().map(LectureDTO::getLectureTitle).forEach(log::info);
    }

    @Test
    public void getTotalTest() {
        log.info("count: " + lectureMapper.getTotal());
    }

    @Test
    public void selectTest() {
        log.info("select: " + lectureMapper.select(97L));
    }

    @Test
    public void temporarySelectAllTest(){
        lectureMapper.temporarySelectAll(new Criteria().create(1, 10)).stream().map(LectureVO::getLectureTitle).forEach(log::info);
    }

    @Test
    public void temporaryAllTest(){
        log.info("count: " + lectureMapper.temporaryGetTotal());
    }

    @Test
    public void updateTest(){
        LectureDTO lectureDTO = new LectureDTO();
        lectureDTO.create(lectureMapper.select(123L));
        lectureDTO.setLectureTitle("수정mapper1");
        lectureDTO.setLectureDate("2022-12-03");
        lectureDTO.setPlaceNumber(1L);
        lectureMapper.update(lectureDTO);
    }

    @Test
    public void temporaryOneTest() {
        lectureMapper.temporaryOne();
    }

    @Test
    public void myReviewTest() {
        LectureVO lectureVO = new LectureVO();
        lectureVO.setTeacherNumber(1L);
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setLectureVO(lectureVO);
        Criteria criteria = new Criteria();
        criteria.create(1, 10);
        lectureMapper.myReviewSelect(criteria, reviewDTO.getLectureVO().getTeacherNumber());
    }

    @Test
    public void myReviewGetTotalTest() {
        LectureVO lectureVO = new LectureVO();
        lectureVO.setTeacherNumber(1L);
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setLectureVO(lectureVO);
        lectureMapper.myReviewGetTotal(reviewDTO.getLectureVO().getTeacherNumber());
    }

    @Test
    public void infoSelectTest() {
        lectureMapper.infoSelect(2L);
    }

    @Test
    public void updatePwTest() {
        TeacherVO teacherVO = new TeacherVO();
        teacherVO.setTeacherNumber(1L);
        teacherVO.setTeacherPassword("teacher01");
    }
}