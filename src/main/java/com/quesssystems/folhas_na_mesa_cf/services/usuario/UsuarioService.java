package com.quesssystems.folhas_na_mesa_cf.services.usuario;

import com.quesssystems.folhas_na_mesa_cf.domains.usuario.Usuario;
import com.quesssystems.folhas_na_mesa_cf.domains.usuario.UsuarioDto;
import com.quesssystems.folhas_na_mesa_cf.repos.UsuarioRepository;
import com.quesssystems.folhas_na_mesa_cf.utils.SenhaUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final SenhaUtil senhaUtil;

    public UsuarioService(UsuarioRepository usuarioRepository, SenhaUtil senhaUtil) {
        this.usuarioRepository = usuarioRepository;
        this.senhaUtil = senhaUtil;
    }

    public UsuarioDto criar(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setSenha(senhaUtil.criptografar("999"));
        usuario.setAdm(usuarioDto.getAdm());

        return usuarioRepository.save(usuario).entityToDto();
    }

    public List<UsuarioDto> listarTodos() {
        List<UsuarioDto> usuarioDtoList = new ArrayList<>();
        usuarioRepository.findAll().forEach(usuario -> usuarioDtoList.add(usuario.entityToDto()));
        return usuarioDtoList;
    }
}
