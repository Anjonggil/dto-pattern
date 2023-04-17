package com.co.kr.dtopattern.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "USER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String nickname;

    private Integer age;

    private Auth auth;

    @Builder(builderMethodName = "of", builderClassName = "of")
    public User(Long id, String username, String password, String nickname, Integer age, Auth auth) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.age = age;
        this.auth = auth;
    }

    @Builder(builderMethodName = "createBuilder",builderClassName = "createBuilder")
    public static User create(String username, String password, String nickname, Integer age){
        return of()
                .username(username)
                .password(password)
                .nickname(nickname)
                .age(age)
                .auth(Auth.USER)
                .build();
    }
}
