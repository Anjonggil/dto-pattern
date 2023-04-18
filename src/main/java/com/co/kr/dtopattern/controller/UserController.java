package com.co.kr.dtopattern.controller;

import com.co.kr.dtopattern.domain.dto.request.UserRequest;
import com.co.kr.dtopattern.domain.dto.response.UserResponse;
import com.co.kr.dtopattern.service.UserService;
import com.co.kr.dtopattern.service.usecase.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserUseCase userUseCase;

    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest) throws URISyntaxException {
        Long userId = userUseCase.createUser(userRequest);
        return ResponseEntity.created(new URI("/api/user/" + userId))
                .build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId){
        UserResponse user = userUseCase.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("")
    public ResponseEntity<?> getUsers(){
        List<UserResponse> userResponses = userUseCase.getUsers();
        return ResponseEntity.ok(userResponses);
    }
}
