package com.co.kr.dtopattern.domain.dto.request;

import java.util.Objects;

public record UserRequest(String username,
                          String password,
                          String nickname,
                          Integer age) {
    public UserRequest{
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);
        Objects.requireNonNull(age);
        Objects.requireNonNull(nickname);
    }
}

/*
public class UserRequest(){

    private final String username;

    private final String password;

    private String nickname;

    private Integer age;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserRequest(String username, String password, String nickname, Integer age) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.age = age;
    }

    public String getNickname() {
        return nickname;
    }

    public Integer getAge() {
        return age;
    }
}

*/