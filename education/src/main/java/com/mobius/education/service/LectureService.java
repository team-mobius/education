package com.mobius.education.service;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.*;
import com.mobius.education.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureDAO lectureDAO;
    private final ReservePlaceDAO reservePlaceDAO;
    private final PlaceDAO placeDAO;
    private final LectureFileDAO lectureFileDAO;
    private final LectureThumbnailDAO lectureThumbnailDAO;

    // 강의 신청
    @Transactional(rollbackFor = Exception.class)
    public void apply(LectureDTO lectureDTO, ReservePlaceVO reservePlaceVO) {
        lectureDAO.save(lectureDTO);
        reservePlaceDAO.save(reservePlaceVO);
        List<LectureFileVO> files = lectureDTO.getFiles();
//        Optional : 검증
        Optional.ofNullable(files).ifPresent(fileList -> {
            fileList.forEach(file -> {
                file.setLectureNumber(lectureDTO.getLectureNumber());
                lectureFileDAO.save(file);
            });
        });
    }


// 강의장 불러오기
    public List<PlaceVO> showPlace(PlaceVO placeVO) {
        return placeDAO.find(placeVO);
    }

//    강의 조회
    public LectureDTO show(Long lectureNumber) {
        return lectureDAO.findById(lectureNumber);
    }

//    강의 전체 조회
    public List<LectureVO> showAll(Criteria criteria) {
        return lectureDAO.findAll(criteria);
    }

//  강의 전체 개수
    public int countAll() {
        return lectureDAO.countTotal();
    }

//    완료 강의 리스트 출력
    public List<LectureVO> showFinishedAll(Criteria criteria) {
        return lectureDAO.findFinishedAll(criteria);
    }

//    완료 강의 개수
    public int finishedGetTotal() {
        return lectureDAO.findFinishedCountAll();
    }

//    진행 중인 강의 리스트 출력
    public List<LectureVO> showOngoingAll(Criteria criteria) {
        return lectureDAO.findOngoingAll(criteria);
    }

//    진행 중인 강의 개수
    public int ongoingGetTotal() {
        return lectureDAO.findOngoingCountAll();
    }

//    예정 강의 리스트 출력
    public List<LectureVO> showExpectedAll(Criteria criteria) {
        return lectureDAO.findExpectedAll(criteria);
    }

//    예정 강의 개수
    public int expectedGetTotal() {
        return lectureDAO.findExpectedCountAll();
    }
}
