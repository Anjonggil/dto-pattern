package com.co.kr.dtopattern.repository;

import com.co.kr.dtopattern.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
