package com.co.kr.dtopattern.domain.dto.request;

import javax.validation.constraints.NotNull;

public record UserRequest(@NotNull String username,
                          @NotNull String password,
                          String nickname,
                          Integer age) {
}
