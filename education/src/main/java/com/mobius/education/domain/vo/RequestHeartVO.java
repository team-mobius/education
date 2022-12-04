package com.mobius.education.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RequestHeartVO {
    private Long requestHeartNumber;
    private Long userNumber;
    private Long requestNumber;

    public void create(Long requestHeartNumber, Long userNumber, Long requestNumber){
        this.requestHeartNumber = requestHeartNumber;
        this.userNumber = userNumber;
        this.requestNumber = requestNumber;
    }
}
