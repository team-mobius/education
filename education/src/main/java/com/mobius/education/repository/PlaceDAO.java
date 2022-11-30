package com.mobius.education.repository;

import com.mobius.education.domain.criteria.Criteria;
import com.mobius.education.domain.vo.LectureVO;
import com.mobius.education.domain.vo.PlaceVO;
import com.mobius.education.mapper.PlaceMapper;
import com.mobius.education.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlaceDAO {
    private final PlaceMapper placeMapper;

    //    강의장 정보 가져오기
    public List<PlaceVO> find(PlaceVO placeVO){
        return placeMapper.select(placeVO);
    }
}
