package com.mobius.education.repository;

import com.mobius.education.domain.vo.LectureFileVO;
import com.mobius.education.mapper.LectureFileMapper;
import com.mobius.education.mapper.LectureMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LectureFileDAO {
    private final LectureFileMapper lectureFileMapper;

    //    파일 추가
    public void save(LectureFileVO lectureFileVO){
        lectureFileMapper.insert(lectureFileVO);
    }


}
