package com.mobius.education.mapper;

import com.mobius.education.domain.vo.ReservePlaceVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReservePlaceMapper {
//    insert
    public void insert(ReservePlaceVO reservePlaceVO);

}
