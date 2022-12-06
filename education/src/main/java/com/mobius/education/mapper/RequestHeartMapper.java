package com.mobius.education.mapper;

import com.mobius.education.domain.vo.RequestHeartVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RequestHeartMapper {
    public int selectHeartCount(Long requestNumber);

    public void insert(RequestHeartVO requestHeartVO);
}
