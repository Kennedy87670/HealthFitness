package com.healthFitness.spring.service;

import com.healthFitness.spring.dto.ActivityDto;

import java.util.List;

public interface ActivityService {
    List<ActivityDto> getAllActivitiesByUser(Long userId);
    ActivityDto saveActivity(ActivityDto activityDTO);

    ActivityDto updateActivity(Long id, ActivityDto activityDto);
    void deleteActivity(Long id);
}
