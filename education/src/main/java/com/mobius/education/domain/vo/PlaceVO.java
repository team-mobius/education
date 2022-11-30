package com.mobius.education.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
public class PlaceVO {
    private Long placeNumber;
    private String placeName;
    private String placeAddress;
    private Long placeMaximumNumber;
    private String placeStatus;
}
