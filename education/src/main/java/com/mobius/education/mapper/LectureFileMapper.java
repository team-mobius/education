package com.mobius.education.mapper;

import com.mobius.education.domain.vo.LectureFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LectureFileMapper {
    //파일 추가
    public void insert(LectureFileVO lectureFileVO);

    //파일 삭제
    public void delete(Long lectureNumber);

    //파일 조회
    public List<LectureFileVO> selectAll(Long lectureNumber);

}
