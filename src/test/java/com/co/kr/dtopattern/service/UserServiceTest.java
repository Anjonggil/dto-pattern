package com.co.kr.dtopattern.service;

import com.co.kr.dtopattern.domain.dto.request.UserRequest;
import com.co.kr.dtopattern.domain.dto.response.UserResponse;
import com.co.kr.dtopattern.domain.entity.Auth;
import com.co.kr.dtopattern.domain.entity.User;
import com.co.kr.dtopattern.mapper.UserRequestMapper;
import com.co.kr.dtopattern.mapper.UserResponseMapper;
import com.co.kr.dtopattern.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    private final UserRequestMapper userRequestMapper = new UserRequestMapper();

    private final UserResponseMapper userResponseMapper = new UserResponseMapper();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository,userRequestMapper,userResponseMapper);
    }

    UserRequest FIXTURE_USER_REQ_01 = new UserRequest(
            "tester01",
            "tester01!@",
            "tester01",
            22);

    User FIXTURE_USER_01 = User.of()
            .username("tester01")
            .password("tester01!@")
            .age(22)
            .nickname("tester01")
            .auth(Auth.USER)
            .build();

    @Test
    void createUser() {
        given(userRepository.save(any())).willReturn(FIXTURE_USER_01);

        Long userId = userService.createUser(FIXTURE_USER_REQ_01);

        assertThat(userId).isEqualTo(FIXTURE_USER_01.getId());
    }

    @Test
    void getUser() {
        given(userRepository.findById(any())).willReturn(Optional.of(FIXTURE_USER_01));
        UserResponse target = userResponseMapper.apply(FIXTURE_USER_01);

        UserResponse userResponse = userService.getUser(1L);
        assertThat(userResponse.id()).isEqualTo(target.id());
        assertThat(userResponse.nickname()).isEqualTo(target.nickname());
        assertThat(userResponse.username()).isEqualTo(target.username());
        assertThat(userResponse.password()).isEqualTo(target.password());
        assertThat(userResponse.age()).isEqualTo(target.age());
    }

    @Test
    void getUsers() {
        given(userRepository.findAll()).willReturn(List.of(FIXTURE_USER_01));

        List<UserResponse> targets = Stream.of(FIXTURE_USER_01).map(userResponseMapper).toList();
        List<UserResponse> users = userService.getUsers();

        assertThat(users.size()).isEqualTo(targets.size());
    }
}