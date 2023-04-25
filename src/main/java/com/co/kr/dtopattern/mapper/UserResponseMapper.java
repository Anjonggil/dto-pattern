package com.co.kr.dtopattern.mapper;

import com.co.kr.dtopattern.domain.dto.response.UserResponse;
import com.co.kr.dtopattern.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserResponseMapper implements Function<User, UserResponse> {
    @Override
    public UserResponse apply(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getNickname(),
                user.getAge(),
                user.getAuth());
    }
}
