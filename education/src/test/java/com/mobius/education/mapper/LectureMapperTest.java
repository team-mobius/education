package com.mobius.education.mapper;

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
class LectureMapperTest {

    @Autowired
    private LectureMapper lectureMapper;

//    강의 추가
    @Test
    public void insertTest(){
        LectureDTO lectureDTO = new LectureDTO();
        lectureDTO.create("강의 넘버 테스트1", "프로그래밍", "개발자의 필수 교양이라 할 수 있는 깃을 명령어 없이, 명령어로 다루는 방법과 깃허브를 능수능란하게 다루는 방법을 배웁니다.",
                "2022-12-20", Long.parseLong("18"), "Time B (13:00~17:00)","진행예정");
        lectureMapper.insert(lectureDTO);
        log.info("number: " + lectureDTO.getLectureNumber());
        log.info("title: " + lectureDTO.getLectureTitle());
        log.info("category: " + lectureDTO.getLectureCategory());
    }

    @Test
    public void deleteTest() {
        LectureVO lectureVO = new LectureVO();
        lectureMapper.delete(Long.parseLong("21"));
    }

    @Test
    public void lectureSelectAllTest(){
        lectureMapper.lectureSelectAll(new Criteria().create(2, 10)).stream().map(LectureVO::getLectureTitle).forEach(log::info);
    }

    @Test
    public void ongoingSelectAllTest(){
        lectureMapper.ongoingSelectAll(new Criteria().create(1, 10)).stream().map(LectureVO::getLectureTitle).forEach(log::info);
    }

    @Test
    public void expectedSelectAllTest(){
        lectureMapper.expectedSelectAll(new Criteria().create(3, 10)).stream().map(LectureVO::getLectureTitle).forEach(log::info);
    }

    @Test
    public void selectAllTest() {
        lectureMapper.selectAll(new Criteria().create(3, 10)).stream().map(LectureVO::getLectureTitle).forEach(log::info);
    }

    @Test
    public void getTotalTest() {
        log.info("count: " + lectureMapper.getTotal());
    }

    @Test
    public void selectTest() {
        log.info("select: " + lectureMapper.select(50L));
    }



}