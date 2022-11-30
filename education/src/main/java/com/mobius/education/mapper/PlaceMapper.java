package com.mobius.education.mapper;

import com.mobius.education.domain.vo.PlaceVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlaceMapper {
//    장소 이름 가져오기
    public List<PlaceVO> select(PlaceVO placeVO);

}
