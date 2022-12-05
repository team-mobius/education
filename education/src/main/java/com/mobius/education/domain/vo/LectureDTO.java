package com.mobius.education.domain.vo;

import com.mobius.education.domain.criteria.Criteria;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class LectureDTO {

    private Long lectureNumber;
    private String lectureTitle;
    private String lectureCategory;
    private String lectureContent;
    private String lectureDate;
    private Long lectureApplyNumber;
    private Long lectureMaximumNumber;
    private String lectureTime;
    private String lecturePlace;
    private String lectureStatus;
    private Long teacherNumber;
    private Long placeNumber;

    private List<LectureFileVO> files;
    private List<LectureThumbnailVO> thumbs;


    public void create(LectureVO lectureVO) {
        this.lectureNumber = lectureVO.getLectureNumber();
        this.lectureTitle = lectureVO.getLectureTitle();
        this.lectureCategory = lectureVO.getLectureCategory();
        this.lectureContent = lectureVO.getLectureContent();
        this.lectureDate = lectureVO.getLectureDate();
        this.lectureApplyNumber = lectureVO.getLectureApplyNumber();
        this.lectureMaximumNumber = lectureVO.getLectureMaximumNumber();
        this.lectureTime = lectureVO.getLectureTime();
        this.lecturePlace = lectureVO.getLecturePlace();
        this.lectureStatus = lectureVO.getLectureStatus();
        this.placeNumber = lectureVO.getPlaceNumber();
    }


    public void create(String lectureTitle, String lectureCategory, String lectureContent, String lectureDate, Long lectureMaximumNumber, String lectureTime, String lecturePlace,String lectureStatus, Long placeNumber, Long teacherNumber) {
        this.lectureTitle = lectureTitle;
        this.lectureCategory = lectureCategory;
        this.lectureContent = lectureContent;
        this.lectureDate = lectureDate;
        this.lectureMaximumNumber = lectureMaximumNumber;
        this.lectureTime = lectureTime;
        this.lecturePlace = lecturePlace;
        this.lectureStatus = lectureStatus;
        this.placeNumber = placeNumber;
        this.teacherNumber = teacherNumber;
    }

    public void create(String lectureTitle, String lectureCategory, String lectureContent, String lectureDate, Long lectureMaximumNumber, String lectureTime, String lecturePlace,String lectureStatus, Long placeNumber,List<LectureFileVO> files, List<LectureThumbnailVO> thumbs) {
        this.lectureTitle = lectureTitle;
        this.lectureCategory = lectureCategory;
        this.lectureContent = lectureContent;
        this.lectureDate = lectureDate;
        this.lectureMaximumNumber = lectureMaximumNumber;
        this.lectureTime = lectureTime;
        this.lecturePlace = lecturePlace;
        this.lectureStatus = lectureStatus;
        this.placeNumber = placeNumber;
        this.files = files;
        this.thumbs = thumbs;
    }

}
