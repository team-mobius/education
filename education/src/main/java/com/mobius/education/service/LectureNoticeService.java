package com.mobius.education.service;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.LectureNoticeVO;
import com.mobius.education.domain.vo.LectureVO;
import com.mobius.education.repository.LectureNoticeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureNoticeService {
    private final LectureNoticeDAO lectureNoticeDAO;

//    공지 추가
    public void save(LectureNoticeVO lectureNoticeVO) {
        lectureNoticeDAO.save(lectureNoticeVO);
    }

//    공지 전체 조회
    public List<LectureNoticeVO> showAll(Long lectureNumber, Criteria criteria){
        return lectureNoticeDAO.findAll(lectureNumber, criteria);
    }

//    공지 전체 개수
    public int countAll() {
        return lectureNoticeDAO.countTotal();
    }

//    공지 조회
    public LectureNoticeVO show(Long lectureNoticeNumber) {
        return lectureNoticeDAO.findById(lectureNoticeNumber);
    }


    public List<LectureNoticeVO> noticeSelectAll() {
        return lectureNoticeDAO.lectureFindAll();
    }
}
