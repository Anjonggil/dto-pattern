package com.co.kr.dtopattern.controller;

import com.co.kr.dtopattern.domain.dto.request.UserRequest;
import com.co.kr.dtopattern.domain.dto.response.UserResponse;
import com.co.kr.dtopattern.service.UserService;
import com.co.kr.dtopattern.service.usecase.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserUseCase userUseCase;

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest){
        UserResponse user = userUseCase.createUser(userRequest);
        return ResponseEntity.ok(user);
    }
}
