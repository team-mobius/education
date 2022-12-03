package com.mobius.education.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LectureNoticeVO {
    private Long lectureNoticeNumber;
    private String lectureNoticeTitle;
    private String lectureNoticeContent;
    private String lectureNoticeDate;
    private Long lectureNumber;

    public void create(String lectureNoticeTitle, String lectureNoticeContent, Long lectureNumber) {
        this.lectureNoticeTitle = lectureNoticeTitle;
        this.lectureNoticeContent = lectureNoticeContent;
        this.lectureNumber = lectureNumber;
    }

    public void create(String lectureNoticeTitle, String lectureNoticeContent) {
        this.lectureNoticeTitle = lectureNoticeTitle;
        this.lectureNoticeContent = lectureNoticeContent;
    }
}
