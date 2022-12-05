package com.mobius.education.repository;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.LectureDTO;
import com.mobius.education.domain.vo.LectureVO;
import com.mobius.education.mapper.LectureMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
    public List<LectureVO> findFinishedAll(Criteria criteria){
        return lectureMapper.lectureSelectAll(criteria);
    }

    //  진행 완료 전체 개수
    public int findFinishedCountAll(){
        return lectureMapper.lectureGetTotal();
    }

    // 진행 완료 강의 전체 조회
    public List<LectureVO> findOngoingAll(Criteria criteria){
        return lectureMapper.ongoingSelectAll(criteria);
    }

    //  진행 완료 전체 개수
    public int findOngoingCountAll(){
        return lectureMapper.ongoingGetTotal();
    }

    // 진행 예정 강의 전체 조회
    public List<LectureVO> findExpectedAll(Criteria criteria){
        return lectureMapper.expectedSelectAll(criteria);
    }

    //  진행 예정 전체 개수
    public int findExpectedCountAll(){
        return lectureMapper.expectedGetTotal();
    }

    // 임시 저장 강의 전체 조회
    public List<LectureVO> findTemporaryAll(Criteria criteria){
        return lectureMapper.temporarySelectAll(criteria);
    }

    // 임시 저장 전체 개수
    public int findTemporaryCountAll(){
        return lectureMapper.temporaryGetTotal();
    }

    //    강의 전체조회
    public List<LectureVO> lectureFindAll() {
        return lectureMapper.lectureSelectAll();
    }
}
