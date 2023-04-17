package com.co.kr.dtopattern.service;

import com.co.kr.dtopattern.domain.dto.request.UserRequest;
import com.co.kr.dtopattern.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserRequestMapper implements Function<UserRequest,User> {

    @Override
    public User apply(UserRequest userRequest) {
        return User.createBuilder()
                .username(userRequest.username())
                .password(userRequest.password())
                .nickname(userRequest.nickname())
                .age(userRequest.age())
                .build();
    }
}
