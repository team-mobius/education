package com.mobius.education.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserVO {

    private Long userNumber;
    private String userEmail;
    private String userPassword;
    private String userNickname;
    private String userPhoneNumber;

    public void create(String userEmail, String userPassword ,String userNickname) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userNickname = userNickname;
    }
}
