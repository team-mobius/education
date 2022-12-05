package com.mobius.education.repository;

import com.mobius.education.domain.vo.LectureVO;
import com.mobius.education.mapper.ApplyLectureMapper;
import com.mobius.education.mapper.LectureMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ApplyLectureDAO {
    private final ApplyLectureMapper applyLectureMapper;

//    내가 들을 강의 수
    public int showMyExpectedLectureCount(Long userNumber){
        return applyLectureMapper.selectOnGoingLectureCount(userNumber);
    }

//    내가 완료한 강의 수
    public int showMyEndLectureCount(Long userNumber){
        return applyLectureMapper.selectEndLectureCount(userNumber);
    }

//    내가 완료한 강의 리스트
    public List<LectureVO> showMyEndedLecture(Long userNumber){
        return applyLectureMapper.selectEndedLecture(userNumber);
    }

    //    나의 진행 중인 강의 리스트
    public List<LectureVO> showMyOnGoingLecture(Long userNumber){
        return applyLectureMapper.selectOnGoingLecture(userNumber);
    }


}
