package com.fawry.user.dtos;


import lombok.*;

@Data
@Getter
@AllArgsConstructor
@Builder
public class AuthenticationResponseDTO {
    private final String jwt;
}
