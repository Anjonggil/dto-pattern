package com.co.kr.dtopattern.service;

import com.co.kr.dtopattern.domain.dto.request.UserRequest;
import com.co.kr.dtopattern.domain.dto.response.UserResponse;
import com.co.kr.dtopattern.domain.entity.User;
import com.co.kr.dtopattern.mapper.UserRequestMapper;
import com.co.kr.dtopattern.mapper.UserResponseMapper;
import com.co.kr.dtopattern.repository.UserRepository;
import com.co.kr.dtopattern.service.usecase.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService implements UserUseCase {

    private final UserRepository userRepository;

    private final UserRequestMapper userRequestMapper;

    private final UserResponseMapper userResponseMapper;

    @Override
    public Long createUser(UserRequest userRequest) {
        User user = userRequestMapper.apply(userRequest);
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public UserResponse getUser(Long userId) {
        return userRepository
                .findById(userId)
                .map(userResponseMapper)
                .orElseThrow();
    }

    @Override
    public List<UserResponse> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userResponseMapper)
                .collect(Collectors.toList());
    }
}
