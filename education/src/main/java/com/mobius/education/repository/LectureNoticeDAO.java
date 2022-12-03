package com.mobius.education.repository;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.LectureNoticeVO;
import com.mobius.education.mapper.LectureNoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LectureNoticeDAO {
    private final LectureNoticeMapper lectureNoticeMapper;

    // 공지 작성
    public void save(LectureNoticeVO lectureNoticeVO){
        lectureNoticeMapper.insert(lectureNoticeVO);
    }

    //공지 전체 조회
    public List<LectureNoticeVO> findAll(Long lectureNumber, Criteria criteria){
        return lectureNoticeMapper.selectAll(lectureNumber, criteria);
    }

    //공지 전체 개수
    public int countTotal() {
        return lectureNoticeMapper.getTotal();
    }

    //선택 공지 보기
    public LectureNoticeVO findById(Long lectureNoticeNumber) {
        return lectureNoticeMapper.select(lectureNoticeNumber);
    }

}
