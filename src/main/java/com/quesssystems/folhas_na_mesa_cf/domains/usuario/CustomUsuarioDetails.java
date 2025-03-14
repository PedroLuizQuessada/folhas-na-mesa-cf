package com.quesssystems.folhas_na_mesa_cf.domains.usuario;

import com.quesssystems.folhas_na_mesa_cf.enums.RoleEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUsuarioDetails implements UserDetails {

    private final Usuario usuario;

    public CustomUsuarioDetails(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.usuario.isAdm()) return List.of(new SimpleGrantedAuthority(RoleEnum.ROLE_ADMIN.toString()), new SimpleGrantedAuthority(RoleEnum.ROLE_USER.toString()));
        else return List.of(new SimpleGrantedAuthority(RoleEnum.ROLE_USER.toString()));
    }

    @Override
    public String getPassword() {
        return usuario.getSenha();
    }

    @Override
    public String getUsername() {
        return usuario.getEmail();
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
