package com.mobius.education.repository;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.LectureDTO;
import com.mobius.education.domain.vo.LectureVO;
import com.mobius.education.domain.vo.ReviewDTO;
import com.mobius.education.domain.vo.TeacherVO;
import com.mobius.education.mapper.LectureMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class LectureDAO {
    private final LectureMapper lectureMapper;

    //강의 신청
    public void save(LectureDTO lectureDTO){
        lectureMapper.insert(lectureDTO);
    }

    //강의 삭제
    public void remove(Long lectureNumber) {
        lectureMapper.delete(lectureNumber);
    }

    //강의 수정
    public void modify(LectureDTO lectureDTO) {
        lectureMapper.update(lectureDTO);
    }

    //강의 조회
    public LectureVO findById(Long lectureNumber) {
        return lectureMapper.select(lectureNumber);
    }

    //강의 전체 조회
    public List<LectureDTO> findAll(Criteria criteria) {
        return lectureMapper.selectAll(criteria);
    }

    //강의 전체 개수
    public int countTotal() {
        return lectureMapper.getTotal();
    }

    // 진행 완료 강의 전체 조회
    public List<LectureVO> findFinishedAll(@Param("criteria") Criteria criteria, @Param("teacherNumber") Long teacherNumber){
        return lectureMapper.finishedSelectAll(criteria, teacherNumber);
    }

    //  진행 완료 전체 개수
    public int findFinishedCountAll(Long teacherNumber){
        return lectureMapper.finishedGetTotal(teacherNumber);
    }

    // 진행 중 강의 전체 조회
    public List<LectureVO> findOngoingAll(@Param("criteria") Criteria criteria, @Param("teacherNumber") Long teacherNumber){
        return lectureMapper.ongoingSelectAll(criteria, teacherNumber);
    }

    //  진행 중 전체 개수
    public int findOngoingCountAll(Long teacherNumber){
        return lectureMapper.ongoingGetTotal(teacherNumber);
    }

    // 진행 예정 강의 전체 조회
    public List<LectureVO> findExpectedAll(@Param("criteria") Criteria criteria, @Param("teacherNumber") Long teacherNumber){
        return lectureMapper.expectedSelectAll(criteria, teacherNumber);
    }

    //  진행 예정 전체 개수
    public int findExpectedCountAll(Long teacherNumber){
        return lectureMapper.expectedGetTotal(teacherNumber);
    }

    // 임시 저장 강의 전체 조회
    public List<LectureVO> findTemporaryAll(Criteria criteria){
        return lectureMapper.temporarySelectAll(criteria);
    }

    // 임시 저장 전체 개수
    public int findTemporaryCountAll(){
        return lectureMapper.temporaryGetTotal();
    }

    // 최신 임시 저장
    public LectureVO temporaryOne() {
        return lectureMapper.temporaryOne();
    }

    // 마이 리뷰 리스트
    public List<ReviewDTO> findMyReviewAll(@Param("criteria") Criteria criteria, @Param("teacherNumber") Long teacherNumber) {
        return lectureMapper.myReviewSelect(criteria, teacherNumber);
    }

    // 마이 리뷰 개수
    public int findMyReviewCountAll(Long teacherNumber) {
        return lectureMapper.myReviewGetTotal(teacherNumber);
    }

    // 마이 인포
    public TeacherVO findInfoById (Long teacherNumber) {
        return lectureMapper.infoSelect(teacherNumber);
    }
}
