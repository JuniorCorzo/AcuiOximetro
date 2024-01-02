package com.empresa.dam.apiacuioximetro.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Role {
    USUARIO(List.of(Permission.READ)), ADMINISTRADOR(List.of(Permission.MODIFYING, Permission.READ));

    private List<Permission> permissions;

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
