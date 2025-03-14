package com.quesssystems.folhas_na_mesa_cf.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {
    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN");

    private final String role;

    RoleEnum(String role) {
        this.role = role;
    }
}
