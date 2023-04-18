package com.co.kr.dtopattern.service.usecase;

import com.co.kr.dtopattern.domain.dto.request.UserRequest;
import com.co.kr.dtopattern.domain.dto.response.UserResponse;

import java.util.List;

public interface UserUseCase {
    Long createUser(UserRequest userRequest);

    UserResponse getUser(Long userId);

    List<UserResponse> getUsers();
}
