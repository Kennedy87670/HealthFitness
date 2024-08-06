package com.healthFitness.spring.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String role;
}
