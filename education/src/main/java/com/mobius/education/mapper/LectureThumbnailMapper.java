package com.mobius.education.mapper;

import com.mobius.education.domain.vo.LectureFileVO;
import com.mobius.education.domain.vo.LectureThumbnailVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LectureThumbnailMapper {
    //파일 추가
    public void insert(LectureThumbnailVO lectureThumbnailVO);

    //파일 삭제
    public void delete(Long lectureNumber);

    //파일 조회
    public List<LectureThumbnailVO> selectAll(Long lectureNumber);
}
