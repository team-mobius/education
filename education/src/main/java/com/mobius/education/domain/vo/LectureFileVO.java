package com.mobius.education.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LectureFileVO {
    private Long lectureFileNumber;
    private String lectureFileName;
    private String lectureFileUploadPath;
    private String lectureFileUuid;
    private Long lectureFileSize;
    private boolean lectureFileCheck;
    private Long lectureNumber;

    public void create(String lectureFileName, String lectureFileUploadPath, String lectureFileUuid, Long lectureFileSize, boolean lectureFileCheck) {
        this.lectureFileName = lectureFileName;
        this.lectureFileUploadPath = lectureFileUploadPath;
        this.lectureFileUuid = lectureFileUuid;
        this.lectureFileSize = lectureFileSize;
        this.lectureFileCheck = lectureFileCheck;
    }

    public void create(String lectureFileName, String lectureFileUploadPath, String lectureFileUuid, Long lectureFileSize, boolean lectureFileCheck, Long lectureNumber) {
        this.lectureFileName = lectureFileName;
        this.lectureFileUploadPath = lectureFileUploadPath;
        this.lectureFileUuid = lectureFileUuid;
        this.lectureFileSize = lectureFileSize;
        this.lectureFileCheck = lectureFileCheck;
        this.lectureNumber = lectureNumber;
    }

}
