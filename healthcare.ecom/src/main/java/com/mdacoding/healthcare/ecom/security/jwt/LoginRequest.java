package com.mdacoding.healthcare.ecom.security.jwt;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class LoginRequest {
    private String username;
    private String password;
}
