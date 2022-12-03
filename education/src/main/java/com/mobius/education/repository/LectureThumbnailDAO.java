package com.mobius.education.repository;

import com.mobius.education.domain.vo.LectureFileVO;
import com.mobius.education.domain.vo.LectureThumbnailVO;
import com.mobius.education.mapper.LectureFileMapper;
import com.mobius.education.mapper.LectureThumbnailMapper;
import com.mobius.education.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LectureThumbnailDAO {
    private final LectureThumbnailMapper lectureThumbnailMapper;

    //    파일 추가
    public void save(LectureThumbnailVO lectureThumbnailVO){
        lectureThumbnailMapper.insert(lectureThumbnailVO);
    }

    //    파일 삭제
    public void remove(Long lectureNumber) {
        lectureThumbnailMapper.delete(lectureNumber);
    }

    //    파일 조회
    public List<LectureThumbnailVO> findAll(Long lectureNumber) {
        return lectureThumbnailMapper.selectAll(lectureNumber);
    }

}
