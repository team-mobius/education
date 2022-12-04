package com.mobius.education.domain.criteria;


import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class RequestDetailCounts {
    private int requestHeartCount;
    private int requestReplyCount;


    public RequestDetailCounts create(int requestHeartCount, int requestReplyCount){
        this.requestHeartCount = requestHeartCount;
        this.requestReplyCount = requestReplyCount;

        return this;
    }


}
