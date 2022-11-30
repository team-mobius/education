package com.mobius.education.repository;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.LectureDTO;
import com.mobius.education.domain.vo.LectureFileVO;
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


    @Test
    public void saveTest() {
        LectureDTO lectureDTO = new LectureDTO();
        lectureDTO.create("쉽게 배우는 자바test","프로그래밍", "초보자, 비전공자도 쉽게 배울 수 있는 자바 수업입니다!", "2022-11-30",
                Long.parseLong("27"), "Time A (09:00~12:00)", "진행중");
        lectureDAO.save(lectureDTO);
        log.info("number: " + lectureDTO.getLectureNumber());
    }

    @Test
    public void removeTest() {
        lectureDAO.remove(Long.parseLong("25"));
    }

    @Test
    public void findFinishedAllTest() {
        lectureDAO.findFinishedAll(new Criteria().create(2, 10)).stream().map(LectureVO::getLectureTitle).forEach(log::info);
    }

    @Test
    public void findOngoingAllTest() {
        lectureDAO.findOngoingAll(new Criteria().create(1, 10)).stream().map(LectureVO::getLectureTitle).forEach(log::info);
    }

    @Test
    public void findExpectedAllTest() {
        lectureDAO.findExpectedAll(new Criteria().create(2, 10)).stream().map(LectureVO::getLectureTitle).forEach(log::info);
    }

    @Test
    public void selectAllTest() {
        lectureDAO.findAll(new Criteria().create(2, 20)).stream().map(LectureVO::getLectureTitle).forEach(log::info);
    }

    @Test
    public void countTotalTest() {
        log.info("count: " + lectureDAO.countTotal());
    }

    @Test
    public void findByIdTest() {
        log.info("findById: " + lectureDAO.findById(50L));
    }


}