package com.example.demo.entity;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class JwtRequest {
    private String email;
    private String password;
}
