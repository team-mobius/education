package com.mobius.education.mapper;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.LectureDTO;
import com.mobius.education.domain.vo.LectureVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LectureMapper {

    //강의 신청
    public void insert(LectureDTO lectureDTO);

    //강의 삭제
    public void delete(Long lectureNumber);

    //강의 수정
    public void update(LectureDTO lectureDTO);

    //강의 조회
    public LectureVO select(Long lectureNumber);

    //모든 강의 조회
    public List<LectureDTO> selectAll(Criteria criteria);

    //모든 강의 개수
    public int getTotal();

    //진행 완료 강의 리스트
    public List<LectureVO> lectureSelectAll(Criteria criteria);

    //진행 완료 강의 개수
    public int lectureGetTotal();

    //진행 중 강의 리스트
    public List<LectureVO> ongoingSelectAll(Criteria criteria);

    //진행 완료 강의 개수
    public int ongoingGetTotal();

    //진행 중 강의 리스트
    public List<LectureVO> expectedSelectAll(Criteria criteria);

    //진행 완료 강의 개수
    public int expectedGetTotal();

    //임시저장 강의 리스트
    public List<LectureVO> temporarySelectAll(Criteria criteria);

    //임시저장 강의 개수
    public int temporaryGetTotal();

    //강의 번호 추가
    public void insertPlace();

}
