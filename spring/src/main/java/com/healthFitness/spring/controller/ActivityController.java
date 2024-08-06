package com.healthFitness.spring.controller;


import com.healthFitness.spring.dto.ActivityDto;
import com.healthFitness.spring.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/activties")
public class ActivityController {

    private final ActivityService activityService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<ActivityDto>> getActivities(@PathVariable Long userId) {
        List<ActivityDto> activities = activityService.getAllActivitiesByUser(userId);
        return ResponseEntity.ok(activities);
    }

    @PostMapping
    public ResponseEntity<ActivityDto> recordActivity(@RequestBody ActivityDto activityDTO) {
        ActivityDto savedActivity = activityService.saveActivity(activityDTO);
        return ResponseEntity.ok(savedActivity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityDto> updateActivity(@PathVariable Long id, @RequestBody ActivityDto activityDto) {
        ActivityDto updatedActivity = activityService.updateActivity(id, activityDto);
        return ResponseEntity.ok(updatedActivity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long id) {
        activityService.deleteActivity(id);
        return ResponseEntity.noContent().build();
    }
}

