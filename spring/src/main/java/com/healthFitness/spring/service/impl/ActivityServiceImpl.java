package com.healthFitness.spring.service.impl;

import com.healthFitness.spring.ExceptionHandler.UsernameNotFoundException;
import com.healthFitness.spring.dto.ActivityDto;
import com.healthFitness.spring.entity.Activity;
import com.healthFitness.spring.entity.User;
import com.healthFitness.spring.repository.ActivityRepository;
import com.healthFitness.spring.repository.UserRespository;
import com.healthFitness.spring.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;
    private final UserRespository userRespository;

    @Override
    public List<ActivityDto> getAllActivitiesByUser(Long userId) {
        List<Activity> activities = activityRepository.findByUserId(userId);
        return activities.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ActivityDto saveActivity(ActivityDto activityDto) {
        Activity activity = mapToEntity(activityDto);
        Activity savedActivity = activityRepository.save(activity);
        return mapToDTO(savedActivity);
    }

    @Override
    public ActivityDto updateActivity(Long id, ActivityDto activityDTO) {
        Activity existingActivity = activityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found"));

        existingActivity.setType(activityDTO.getType());
        existingActivity.setTimestamp(activityDTO.getTimestamp());
        existingActivity.setDetails(activityDTO.getDetails());

        Activity updatedActivity = activityRepository.save(existingActivity);
        return mapToDTO(updatedActivity);
    }

    @Override
    public void deleteActivity(Long id) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found"));
        activityRepository.delete(activity);
    }

    private ActivityDto mapToDTO(Activity activity) {
        ActivityDto activityDTO = new ActivityDto();
        activityDTO.setId(activity.getId());
        activityDTO.setUserId(activity.getUser().getId());
        activityDTO.setType(activity.getType());
        activityDTO.setTimestamp(activity.getTimestamp());
        activityDTO.setDetails(activity.getDetails());
        return activityDTO;
    }

    private Activity mapToEntity(ActivityDto activityDto) {
        Activity activity = new Activity();
        activity.setId(activityDto.getId());
        activity.setType(activityDto.getType());
        activity.setTimestamp(activityDto.getTimestamp());
        activity.setDetails(activityDto.getDetails());
        User user = userRespository.findById(activityDto.getUserId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        activity.setUser(user);

        return activity;
    }
}