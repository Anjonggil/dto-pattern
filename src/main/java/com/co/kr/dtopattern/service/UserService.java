package com.co.kr.dtopattern.service;

import com.co.kr.dtopattern.domain.dto.request.UserRequest;
import com.co.kr.dtopattern.domain.dto.response.UserResponse;
import com.co.kr.dtopattern.repository.UserRepository;
import com.co.kr.dtopattern.service.usecase.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService implements UserUseCase {

    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        return null;
    }
}
