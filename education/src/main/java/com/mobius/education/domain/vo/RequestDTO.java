package com.mobius.education.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RequestDTO {
    private Long requestNumber;
    private String requestTitle;
    private String requestCategory;
    private String requestContent;
    private String requestRegisterDate;
    private String requestModifyDate;
    private Long userNumber;
    private String userNickname;
    private int heartCount;
    private int replyCount;

    public RequestDTO create(int heartCount , int replyCount){
        this.heartCount = heartCount;
        this.replyCount = replyCount;
        return this;
    }
}
