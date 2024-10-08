package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private int id;
    private String name;
    private String surName;
    private int age;
    private String dob;
    private Long gender;
    private String address;
    private String phone;
    private String email;
}
