package com.mobius.education.mapper;

import com.mobius.education.domain.vo.LectureFileVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LectureFileMapper {
    //파일 추가
    public void insert(LectureFileVO lectureFileVO);
}
