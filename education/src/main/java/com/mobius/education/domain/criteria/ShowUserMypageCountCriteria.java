package com.mobius.education.domain.criteria;


import lombok.Data;
import org.springframework.stereotype.Component;



@Component
@Data
public class ShowUserMypageCountCriteria {
    private int userReviewCount;
    private int userRequestCount;
    private int userExpectedLectureCount;
    private int userEndLectureCount;

    public ShowUserMypageCountCriteria create(int userReviewCount, int userRequestCount, int userExpectedLectureCount, int userEndLectureCount){
        this.userReviewCount=userReviewCount;
        this.userRequestCount=userRequestCount;
        this.userExpectedLectureCount = userEndLectureCount;
        this.userEndLectureCount = userEndLectureCount;
        return this;
    }


}
