package com.co.kr.dtopattern.domain.dto.response;

import com.co.kr.dtopattern.domain.entity.Auth;

import javax.validation.constraints.NotNull;

public record UserResponse(Long id,
                           String username,
                           String password,
                           String nickname,
                           Integer age,
                           Auth auth) {
}
