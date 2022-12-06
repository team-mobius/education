package com.mobius.education.service;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.*;
import com.mobius.education.repository.*;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
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
        reservePlaceVO.setReservePlaceDate(lectureDTO.getLectureDate());
        reservePlaceVO.setPlaceNumber(lectureDTO.getPlaceNumber());

        lectureDAO.save(lectureDTO);
        reservePlaceDAO.save(reservePlaceVO);

        List<LectureFileVO> files = lectureDTO.getFiles();
        List<LectureThumbnailVO> thumbs = lectureDTO.getThumbs();

//        Optional : 검증
        Optional.ofNullable(files).ifPresent(fileList -> {
            fileList.forEach(file -> {
                file.setLectureNumber(lectureDTO.getLectureNumber());
                lectureFileDAO.save(file);
            });
        });
        Optional.ofNullable(thumbs).ifPresent(thumbList -> {
            thumbList.forEach(thumb -> {
                thumb.setLectureNumber(lectureDTO.getLectureNumber());
                lectureThumbnailDAO.save(thumb);
            });
        });
    }

//    강의 삭제
    @Transactional(rollbackFor = Exception.class)
    public void remove(Long lectureNumber) {
        lectureFileDAO.remove(lectureNumber);
        lectureThumbnailDAO.remove(lectureNumber);
        lectureDAO.remove(lectureNumber);
    }

    
//    강의 수정
    @Transactional(rollbackFor = Exception.class)
    public void modify(LectureDTO lectureDTO, ReservePlaceVO reservePlaceVO) {
        reservePlaceVO.setReservePlaceDate(lectureDTO.getLectureDate());
        reservePlaceVO.setPlaceNumber(lectureDTO.getPlaceNumber());

        lectureDAO.modify(lectureDTO);
        reservePlaceDAO.save(reservePlaceVO);
        lectureFileDAO.remove(lectureDTO.getLectureNumber());
        lectureThumbnailDAO.remove(lectureDTO.getLectureNumber());

        List<LectureFileVO> files = lectureDTO.getFiles();
        List<LectureThumbnailVO> thumbs = lectureDTO.getThumbs();

        Optional.ofNullable(files).ifPresent(fileList -> {
            fileList.forEach(file -> {
                file.setLectureNumber(lectureDTO.getLectureNumber());
                lectureFileDAO.save(file);
            });
        });
        Optional.ofNullable(thumbs).ifPresent(thumbList -> {
            thumbList.forEach(thumb -> {
                thumb.setLectureNumber(lectureDTO.getLectureNumber());
                lectureThumbnailDAO.save(thumb);
            });
        });
    }

// 강의장 불러오기
    public List<PlaceVO> showPlace(PlaceVO placeVO) {
        return placeDAO.find(placeVO);
    }

//    강의 조회
    public LectureDTO show(Long lectureNumber) {
        LectureDTO lectureDTO = new LectureDTO();
        lectureDTO.create(lectureDAO.findById(lectureNumber));
        lectureDTO.setFiles(lectureFileDAO.findAll(lectureNumber));
        lectureDTO.setThumbs(lectureThumbnailDAO.findAll(lectureNumber));
        return lectureDTO;
    }

//    강의 전체 조회
    public List<LectureDTO> showAll(Criteria criteria) {
        return lectureDAO.findAll(criteria);
    }

//  강의 전체 개수
    public int countAll() {
        return lectureDAO.countTotal();
    }

//    완료 강의 리스트 출력
    public List<LectureVO> showFinishedAll(Criteria criteria, Long teacherNumber) {
        return lectureDAO.findFinishedAll(criteria, teacherNumber);
    }

//    완료 강의 개수
    public int finishedGetTotal(Long teacherNumber) {
        return lectureDAO.findFinishedCountAll(teacherNumber);
    }

//    진행 중인 강의 리스트 출력
    public List<LectureVO> showOngoingAll(@Param("criteria") Criteria criteria, @Param("teacherNumber") Long teacherNumber) {
        return lectureDAO.findOngoingAll(criteria, teacherNumber);
    }

//    진행 중인 강의 개수
    public int ongoingGetTotal(Long teacherNumber) {
        return lectureDAO.findOngoingCountAll(teacherNumber);
    }

//    예정 강의 리스트 출력
    public List<LectureVO> showExpectedAll(@Param("criteria") Criteria criteria, @Param("teacherNumber") Long teacherNumber) {
        return lectureDAO.findExpectedAll(criteria, teacherNumber);
    }

//    예정 강의 개수
    public int expectedGetTotal(Long teacherNumber) {
        return lectureDAO.findExpectedCountAll(teacherNumber);
    }

//    임시저장 리스트 출력
    public List<LectureVO> showTemporaryAll(Criteria criteria) {
        return lectureDAO.findTemporaryAll(criteria);
    }

//    임시저장 강의 개수
    public int temporaryGetTotal() {
        return lectureDAO.findTemporaryCountAll();
    }

//    최신 임시 강의
    public LectureVO temporaryLast() {
        return lectureDAO.temporaryOne();
    }

//    마이 리뷰 리스트
    public List<ReviewDTO> showMyReviewAll(@Param("criteria") Criteria criteria, @Param("teacherNumber") Long teacherNumber) {
        return lectureDAO.findMyReviewAll(criteria, teacherNumber);
    }

//    마이 리뷰 개수
    public int myReviewGetTotal(Long teacherNumber) {
        return lectureDAO.findMyReviewCountAll(teacherNumber);
    }

//    마인 인포 조회
    public TeacherVO showMyInfo(Long teacherNumber) {
        return lectureDAO.findInfoById(teacherNumber);
    }

//    메인 강의조회
    public List<LectureVO> mainLectureShowAll() {
    return lectureDAO.mainLectureFindAll();
}

    public LectureDTO mainDetailSelect(Long lectureNumber) {
        return lectureDAO.mainDetailFingById(lectureNumber);
    }



}
