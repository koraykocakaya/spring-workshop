package com.kk.workshop.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsernameAndPasswordAuthenticationRequest {

    private String username;
    private String password;
}
