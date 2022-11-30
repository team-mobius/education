package com.mobius.education.repository;

import com.mobius.education.domain.vo.ReviewVO;
import com.mobius.education.mapper.PlaceMapper;
import com.mobius.education.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewDAO {
    private final ReviewMapper reviewMapper;

//    전체조회
    public List<ReviewVO> findAll(){
        return reviewMapper.selectAll();
}

}
