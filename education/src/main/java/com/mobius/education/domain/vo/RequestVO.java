package com.mobius.education.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RequestVO {
    private Long requestNumber;
    private String requestTitle;
    private String requestCategory;
    private String requestContent;
    private String requestRegisterDate;
    private String requestModifyDate;

    public void create(String requestTitle, String requestCategory, String requestContent) {
        this.requestTitle = requestTitle;
        this.requestCategory = requestCategory;
        this.requestContent = requestContent;
    }
}
