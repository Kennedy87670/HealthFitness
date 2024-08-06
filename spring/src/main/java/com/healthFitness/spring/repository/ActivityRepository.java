package com.healthFitness.spring.repository;

import com.healthFitness.spring.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository <Activity, Long> {
    List<Activity> findByUserId(Long userId);
}