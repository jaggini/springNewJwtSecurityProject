package com.example.springsecurityJwtProject.exchanges.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
  private final String message = "Success";
  private String accessToken;
}