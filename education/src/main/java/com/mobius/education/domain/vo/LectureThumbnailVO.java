package com.mobius.education.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LectureThumbnailVO {
    private Long lectureThumbnailNumber;
    private String lectureThumbnailName;
    private String lectureThumbnailUploadPath;
    private String lectureThumbnailUuid;
    private Long lectureThumbnailSize;
    private boolean lectureThumbnailCheck;
    private Long lectureNumber;

    public void create(String lectureThumbnailName, String lectureThumbnailUploadPath, String lectureThumbnailUuid, Long lectureNumber) {
        this.lectureThumbnailName = lectureThumbnailName;
        this.lectureThumbnailUploadPath = lectureThumbnailUploadPath;
        this.lectureThumbnailUuid = lectureThumbnailUuid;
        this.lectureNumber = lectureNumber;
    }
}
