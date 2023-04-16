package com.co.kr.dtopattern.service.usecase;

import com.co.kr.dtopattern.domain.dto.request.UserRequest;
import com.co.kr.dtopattern.domain.dto.response.UserResponse;

public interface UserUseCase {
    UserResponse createUser(UserRequest userRequest);
}
