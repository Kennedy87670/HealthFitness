package com.healthFitness.spring.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ActivityDto {
    private Long id;
    private Long userId;
    private String type;
    private LocalDateTime timestamp;
    private String details;

}
