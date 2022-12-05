package com.mobius.education.mapper;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.LectureNoticeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LectureNoticeMapper {
    // 공지 작성
    public void insert(LectureNoticeVO lectureNoticeVO);

    //모든 공지 조회
    public List<LectureNoticeVO> selectAll(@Param("lectureNumber") Long lectureNumber, @Param("criteria") Criteria criteria);

    //모든 공지 개수
    public int getTotal();

    //공지 보기
    public LectureNoticeVO select(Long lectureNoticeNumber);

    public List<LectureNoticeVO> noticeSelectAll();
}
