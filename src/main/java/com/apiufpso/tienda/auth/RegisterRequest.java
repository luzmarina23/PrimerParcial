package com.apiufpso.tienda.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    String firstName;
    String lastName;
    String document;
    String phone;
    String email;
    String password;
}
