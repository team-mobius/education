package com.mobius.education.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
public class TeacherVO {
    private Long teacherNumber;
    private String teacherEmail;
    private String teacherPassword;
    private String teacherName;
    private String teacherBelonging;
    private String teacherPhoneNumber;

    public void create(Long teacherNumber, String teacherEmail ,String teacherPassword, String teacherName, String teacherBelonging,String teacherPhoneNumber) {
        this.teacherNumber = teacherNumber;
        this.teacherEmail = teacherEmail;
        this.teacherPassword = teacherPassword;
        this.teacherName = teacherName;
        this.teacherBelonging = teacherBelonging;
        this.teacherPhoneNumber = teacherPhoneNumber;
    }

}
