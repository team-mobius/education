package com.mobius.education.mapper;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.LectureDTO;
import com.mobius.education.domain.vo.LectureVO;
import com.mobius.education.domain.vo.ReviewDTO;
import com.mobius.education.domain.vo.TeacherVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    public List<LectureVO> finishedSelectAll(@Param("criteria") Criteria criteria, @Param("teacherNumber") Long teacherNumber);

    //진행 완료 강의 개수
    public int finishedGetTotal(Long teacherNumber);

    //진행 중 강의 리스트
    public List<LectureVO> ongoingSelectAll(@Param("criteria") Criteria criteria, @Param("teacherNumber") Long teacherNumber);

    //진행 중 강의 개수
    public int ongoingGetTotal(Long teacherNumber);

    //진행 예정 강의 리스트
    public List<LectureVO> expectedSelectAll(@Param("criteria") Criteria criteria, @Param("teacherNumber") Long teacherNumber);

    //진행 예정 강의 개수
    public int expectedGetTotal(Long teacherNumber);

    //임시저장 강의 리스트
    public List<LectureVO> temporarySelectAll(Criteria criteria);

    //임시저장 강의 개수
    public int temporaryGetTotal();

    //강의 번호 추가
    public void insertPlace();

    //최근 임시 강의
    public LectureVO temporaryOne();

    //강사 마이 리뷰
    public List<ReviewDTO> myReviewSelect(@Param("criteria") Criteria criteria, @Param("teacherNumber") Long teacherNumber);

    //강사 마이 리뷰 3개
    public List<ReviewDTO> myReviewSelectThree(Long teacherNumber);

    //강사 마이 리뷰 개수
    public int myReviewGetTotal(Long teacherNumber);

    //마이 인포
    public TeacherVO infoSelect(Long teacherNumber);

    //비번 변경
    public void updatePw(TeacherVO teacherVO);

    //회원 탈퇴
    public void deleteTeacher(Long teacherNumber);

    //
    public void deleteTeacherLecture(Long teacherNumber);


    //    리뷰를 위한 강의 정보
    public LectureVO selectLecDetailAndAll(Long teacherNumber);

//    메인페이지 강의 리스트
    public List<LectureVO> mainpageLectureSelectAll();

//메인 강의 상세정보
    public LectureDTO mainDetailSelect(Long lectureNumber);


}
