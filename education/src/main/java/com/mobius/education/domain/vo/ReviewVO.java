package com.mobius.education.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReviewVO {
    private Long reviewNumber;
    private String reviewTitle;
    private String reviewContent;
    private String reviewRegisterDate;
    private String reviewModifyDate;
    private Long lectureNumber;
    private Long userNumber;
}
