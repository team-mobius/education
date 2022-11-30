package com.mobius.education.mapper;

import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ApplyLectureMapper {
    // 사용자 신청 강의 중 진행 중인 강의 조회
    public Integer selectOnGoingLectureCount(Long userNumber);

    // 사용자 신청 강의 중 완료 된 강의 조회
    public Integer selectEndLectureCount(Long userNumber);

}
