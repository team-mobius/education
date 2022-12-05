package com.mobius.education.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReviewDTO {
    private Long reviewNumber;
    private String reviewTitle;
    private String reviewContent;
    private String reviewRegisterDate;
    private String reviewModifyDate;
    private Long lectureNumber;
    private Long userNumber;
    private String userNickname;

    private LectureVO lectureVO;
    private String lectureTitle;
    private Long teacherNumber;

    public void create(Long reviewNumber, String reviewTitle, String reviewContent, String reviewRegisterDate, String reviewModifyDate, Long lectureNumber, Long userNumber, String userNickname){
        this.reviewNumber = reviewNumber;
        this.reviewTitle = reviewTitle;
        this.reviewContent = reviewContent;
        this.reviewRegisterDate = reviewRegisterDate;
        this.reviewModifyDate = reviewModifyDate;
        this.lectureNumber = lectureNumber;
        this.userNumber = userNumber;
        this.userNickname = userNickname;
    }

}
