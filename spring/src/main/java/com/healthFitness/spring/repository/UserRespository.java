package com.healthFitness.spring.repository;

import com.healthFitness.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRespository extends JpaRepository<User, Long>{

    Optional<User> findByUserName(String userName);
}
