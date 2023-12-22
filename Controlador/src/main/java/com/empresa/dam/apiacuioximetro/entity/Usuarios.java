package com.empresa.dam.apiacuioximetro.entity;

import com.empresa.dam.apiacuioximetro.utils.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "usuarios")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuarios implements UserDetails {
    // Identificador único del usuario.
    @Id
    @Column(name = "id_usuario")
    @NotNull
    private int idUsuario;

    // Rol del usuario en el sistema.

    @Column(name = "rol")
    @NotNull
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private Role rol;

    // Nombre del usuario.

    @Column(name = "nombre")
    @NotNull
    @NotEmpty
    private String nombre;

    // Apellido del usuario.
    @Column(name = "apellido")
    @NotNull
    @NotEmpty
    private String apellido;

    // Correo electrónico del usuario.

    @Column(name = "correo")
    @NotNull
    @NotEmpty
    @Email
    private String correo;

    // Clave de acceso del usuario.

    @Column(name = "clave")
    @NotNull
    @NotEmpty
    private String clave;
    @Column(name = "token")
    private String token;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = rol.getPermissions().stream()
                .map(permissionsEnum -> new SimpleGrantedAuthority(permissionsEnum.name()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + rol.name()));

        return authorities;
    }

    @Override
    public String getPassword() {
        return clave;
    }

    @Override
    public String getUsername() {
        return nombre;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
