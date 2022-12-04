package com.mobius.education.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RequestCommentDTO {
    private Long requestCommentNumber;
    private String requestCommentContent;
    private Long userNumber;
    private Long requestNumber;
    private String requestCommentRegisterDate;
    private String requestCommentModifyDate;
    private String userNickname;
}
