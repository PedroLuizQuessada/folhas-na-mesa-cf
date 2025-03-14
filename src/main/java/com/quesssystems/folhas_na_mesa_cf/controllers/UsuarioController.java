package com.quesssystems.folhas_na_mesa_cf.controllers;

import com.quesssystems.folhas_na_mesa_cf.domains.usuario.UsuarioDto;
import com.quesssystems.folhas_na_mesa_cf.services.usuario.UsuarioService;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/usuarios")
public class UsuarioController implements ErrorController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/criar")
    public @ResponseBody UsuarioDto criar(@RequestBody @Validated UsuarioDto usuarioDto) {
        return usuarioService.criar(usuarioDto);
    }

    @GetMapping("/listarTodos")
    public @ResponseBody List<UsuarioDto> listarTodos() {
        return usuarioService.listarTodos();
    }
}
