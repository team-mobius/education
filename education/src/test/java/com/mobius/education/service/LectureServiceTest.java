package com.mobius.education.service;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.*;
import com.mobius.education.repository.ReservePlaceDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@Slf4j
class LectureServiceTest {

    @Autowired
    private LectureService lectureService;


    @Test
    public void applyTest() {
        LectureDTO lectureDTO = new LectureDTO();
        LectureFileVO file1 = new LectureFileVO();
        LectureFileVO file2 = new LectureFileVO();
        LectureThumbnailVO thumb = new LectureThumbnailVO();
        ReservePlaceVO reservePlaceVO = new ReservePlaceVO();


        file1.create("강사넘버서비스테스트1", "2022/12/03", UUID.randomUUID().toString(), 200L, true);
        file2.create("강사넘버서비스테스트1", "2022/12/03", UUID.randomUUID().toString(), 100L, true);
        thumb.create("강사넘버서비스테스트1", "2022/12/03", UUID.randomUUID().toString(), 200L, true);
        List<LectureFileVO> files = new ArrayList<>(Arrays.asList(file1, file2));
        List<LectureThumbnailVO> thumbs = new ArrayList<>(Arrays.asList(thumb));
        reservePlaceVO.create(true, false, false);
        lectureDTO.create("강사넘버서비스테스트1", "IT", "개발자의 필수 교양이라 할 수 있는 깃을 명령어 없이, 명령어로 다루는 방법과 깃허브를 능수능란하게 다루는 방법을 배웁니다.",
                "2022-12-08", 20L, "Time B (13:00~17:00)","뫼비우스 강연장 5F 501", "진행예정", 21L, 2L);

        lectureDTO.setFiles(files);
        lectureDTO.setThumbs(thumbs);

        lectureService.apply(lectureDTO, reservePlaceVO);
        log.info("lectureTitle: " + lectureDTO.getLectureTitle());
        log.info("lectureTitle: " + lectureDTO.getLectureNumber());

    }


    @Test
    public void modifyTest() {

    }

    @Test
    public void showLectureAllTest(){
        lectureService.showFinishedAll(new Criteria().create(1, 10), 2L).stream().map(LectureVO::getLectureTitle).forEach(log::info);
    }

    @Test
    public void showOngoingAllTest(){
        lectureService.showOngoingAll(new Criteria().create(1, 10), 2L).stream().map(LectureVO::getLectureTitle).forEach(log::info);
    }

    @Test
    public void showExpectedAllTest(){
        lectureService.showExpectedAll(new Criteria().create(1, 10), 2L).stream().map(LectureVO::getLectureTitle).forEach(log::info);
    }

    @Test
    public void showAllTest() {
        lectureService.showAll(new Criteria().create(2, 20)).stream().map(LectureDTO::getLectureTitle).forEach(log::info);

    }

    @Test
    public void showTest() {
        log.info("show: " + lectureService.show(50L));
    }

    @Test
    public void removeTest() {
        lectureService.remove(219L);
    }

    @Test
    public void temporaryLastTest() {
        lectureService.temporaryLast();
    }

    @Test
    public void showMyReviewAllTest() {
        lectureService.showMyReviewAll(new Criteria().create(1, 3), 1L);
    }

    @Test
    public void myReviewGetTotalTest() {
        lectureService.myReviewGetTotal(1L);
    }

    @Test
    public void showMyInfoTest() {
        lectureService.showMyInfo(2L);
    }
}