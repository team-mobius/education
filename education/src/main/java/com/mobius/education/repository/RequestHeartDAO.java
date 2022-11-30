package com.mobius.education.repository;

import com.mobius.education.mapper.RequestHeartMapper;
import com.mobius.education.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RequestHeartDAO {
    private final RequestHeartMapper requestHeartMapper;

}
