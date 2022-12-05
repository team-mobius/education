package com.mobius.education.repository;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.LectureDTO;
import com.mobius.education.domain.vo.LectureVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class LectureDAOTest {

    @Autowired
    private LectureDAO lectureDAO;


//    @Test
//    public void saveTest() {
//        LectureDTO lectureDTO = new LectureDTO();
//        lectureDTO.create("강사 넘버 dao test1","프로그래밍", "초보자, 비전공자도 쉽게 배울 수 있는 자바 수업입니다!", "2022-11-30",
//                27L, "Time A (09:00~12:00)", "뫼비우스 강연장 5F 501","진행예정", 1L, 1L);
//        lectureDAO.save(lectureDTO);
//        log.info("number: " + lectureDTO.getLectureNumber());
//    }
//
//    @Test
//    public void removeTest() {
//        lectureDAO.remove(164L);
//    }
//
    @Test
    public void findFinishedAllTest() {
        lectureDAO.findFinishedAll(new Criteria().create(1, 10), 2L).stream().map(LectureVO::getLectureTitle).forEach(log::info);
    }
//
//    @Test
//    public void findOngoingAllTest() {
//        lectureDAO.findOngoingAll(new Criteria().create(1, 10)).stream().map(LectureVO::getLectureTitle).forEach(log::info);
//    }
//
//    @Test
//    public void findExpectedAllTest() {
//        lectureDAO.findExpectedAll(new Criteria().create(2, 10)).stream().map(LectureVO::getLectureTitle).forEach(log::info);
//    }
//
//    @Test
//    public void selectAllTest() {
//        lectureDAO.findAll(new Criteria().create(2, 20)).stream().map(LectureDTO::getLectureTitle).forEach(log::info);
//    }
//
//    @Test
//    public void countTotalTest() {
//        log.info("count: " + lectureDAO.countTotal());
//    }
//
//    @Test
//    public void findByIdTest() {
//        log.info("findById: " + lectureDAO.findById(50L));
//    }
//
//    @Test
//    public void findTemporaryAllTest() {
//        lectureDAO.findTemporaryAll(new Criteria().create(1, 10)).stream().map(LectureVO::getLectureTitle).forEach(log::info);
//    }
//
//    @Test
//    public void temporaryGetTotalTest() {
//        log.info("count: " + lectureDAO.findTemporaryCountAll());
//    }
//
//    @Test
//    public void modifyTest() {
//        LectureDTO lectureDTO = new LectureDTO();
//        lectureDTO.create(lectureDAO.findById(123L));
//        lectureDTO.setLectureTitle("수정dao1");
//        lectureDTO.setLectureDate("2022-12-02");
//        lectureDAO.modify(lectureDTO);
//    }
//
//    @Test
//    public void temporaryOneTest() {
//        lectureDAO.temporaryOne();
//    }
//
//    @Test
//    public void myReviewListTest()  {
//        lectureDAO.findMyReviewAll(new Criteria().create(1, 10), 1L);
//    }
//
//    @Test
//    public void myReviewCountTest() {
//        lectureDAO.findMyReviewCountAll(1L);
//    }

    @Test
    public void findInfoByIdTest() {
        lectureDAO.findInfoById(2L);
    }
}