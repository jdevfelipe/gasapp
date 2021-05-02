package com.api.apiauth.dtos;

import com.api.apiauth.models.Role;

import java.io.Serializable;
import java.time.LocalDate;

public class UserDTO implements Serializable {
    private long id;
    private String name;
    private String email;
    private LocalDate birthdate;
    private Role role;
}
