package com.mobius.education.repository;

import com.mobius.education.mapper.PlaceFileMapper;
import com.mobius.education.mapper.RequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PlaceFileDAO {
    private final PlaceFileMapper placeFileMapper;

}
