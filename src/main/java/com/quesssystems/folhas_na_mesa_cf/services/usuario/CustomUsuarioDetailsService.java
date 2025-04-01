package com.quesssystems.folhas_na_mesa_cf.services.usuario;

import com.quesssystems.folhas_na_mesa_cf.domains.usuario.CustomUsuarioDetails;
import com.quesssystems.folhas_na_mesa_cf.domains.usuario.Usuario;
import com.quesssystems.folhas_na_mesa_cf.repos.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUsuarioDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public CustomUsuarioDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException(String.format("E-mail %s não está cadastrado", email));
        }

        return new CustomUsuarioDetails(usuario);
    }
}
