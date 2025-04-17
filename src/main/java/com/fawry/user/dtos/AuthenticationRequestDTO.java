package com.fawry.user.dtos;

import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequestDTO {
    private String username;
    private String password;
}

