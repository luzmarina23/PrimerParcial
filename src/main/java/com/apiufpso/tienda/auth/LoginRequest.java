package com.apiufpso.tienda.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.aspectj.bridge.IMessage;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginRequest {
    @NotNull(message = "email is required")
    @Email(message = "email not valid")
    private String email;
    @NotNull(message = "email is required")
    @Size(min = 8,message = "password min 8 characters")
    private String password;
}
