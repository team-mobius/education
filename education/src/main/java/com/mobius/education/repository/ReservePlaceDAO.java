package com.mobius.education.repository;

import com.mobius.education.domain.vo.LectureDTO;
import com.mobius.education.domain.vo.ReservePlaceVO;
import com.mobius.education.mapper.RequestCommentMapper;
import com.mobius.education.mapper.ReservePlaceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReservePlaceDAO {
    private final ReservePlaceMapper reservePlaceMapper;

    //장소 예약 추가
    public void save(ReservePlaceVO reservePlaceVO) {
        reservePlaceMapper.insert(reservePlaceVO);
    }
}
