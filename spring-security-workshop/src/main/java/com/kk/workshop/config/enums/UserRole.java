package com.kk.workshop.config.enums;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.kk.workshop.config.enums.UserPermission.*;

@AllArgsConstructor
@Getter
public enum UserRole {
    ADMIN(Sets.newHashSet(STUDENT_READ, PERSON_READ, PERSON_WRITE, STUDENT_WRITE)),
    PERSON_ADMIN(Sets.newHashSet(PERSON_WRITE));

    private final Set<UserPermission> permissions;

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> pers = permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        pers.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return pers;
    }
}
