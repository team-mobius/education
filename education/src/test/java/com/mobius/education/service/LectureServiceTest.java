package com.mobius.education.service;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.LectureDTO;
import com.mobius.education.domain.vo.LectureFileVO;
import com.mobius.education.domain.vo.LectureVO;
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


//    @Test
//    public void applyTest() {
//        LectureDTO lectureDTO = new LectureDTO();
//        LectureFileVO file = new LectureFileVO();
//
//        file.create("테스트service7", "2022/11/28", UUID.randomUUID().toString(), 200L);
//        List<LectureFileVO> files = new ArrayList<>(Arrays.asList(file));
//        lectureDTO.create("서비스테스트7", "프로그래밍", "개발자의 필수 교양이라 할 수 있는 깃을 명령어 없이, 명령어로 다루는 방법과 깃허브를 능수능란하게 다루는 방법을 배웁니다.",
//                "2022-12-20", 20L, "Time B (13:00~17:00)","진행예정");
//        lectureDTO.setFiles(files);
//        lectureService.apply(lectureDTO,);
//        log.info("lectureTitle: " + lectureDTO.getLectureTitle());
//        log.info("lectureNumber: " + lectureDTO.getLectureNumber());
//        log.info("fileName: " + file.getLectureFileName());
//
//    }


    @Test
    public void modifyTest() {

    }

    @Test
    public void showLectureAllTest(){
        lectureService.showFinishedAll(new Criteria().create(2, 10)).stream().map(LectureVO::getLectureTitle).forEach(log::info);
    }

    @Test
    public void showOngoingAllTest(){
        lectureService.showOngoingAll(new Criteria().create(1, 10)).stream().map(LectureVO::getLectureTitle).forEach(log::info);
    }

    @Test
    public void showExpectedAllTest(){
        lectureService.showExpectedAll(new Criteria().create(2, 10)).stream().map(LectureVO::getLectureTitle).forEach(log::info);
    }

    @Test
    public void showAllTest() {
        lectureService.showAll(new Criteria().create(2, 20)).stream().map(LectureVO::getLectureTitle).forEach(log::info);

    }

    @Test
    public void showTest() {
        log.info("show: " + lectureService.show(50L));
    }

}