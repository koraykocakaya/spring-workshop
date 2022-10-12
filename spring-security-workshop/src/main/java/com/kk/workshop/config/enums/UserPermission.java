package com.kk.workshop.config.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum UserPermission {
    PERSON_READ("person:read"),
    PERSON_WRITE("person:write"),
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write");

    private String permission;

}
