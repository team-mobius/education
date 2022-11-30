package com.mobius.education.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ApplyLectureVO {
    private Long applyLectureNumber;
    private Long userNumber;
    private Long lectureNumber;
}
