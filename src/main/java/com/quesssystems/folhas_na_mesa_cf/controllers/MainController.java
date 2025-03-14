package com.quesssystems.folhas_na_mesa_cf.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController implements ErrorController {

    @GetMapping("/login")
    public String iniciar() {
        return "login";
    }

    @GetMapping("/teste")
    public String teste() {
        return "teste";
    }

    @GetMapping("/liberada")
    public ResponseEntity<String> liberada() {
        return ResponseEntity.ok("resposta liberada");
    }

    @GetMapping("/autenticada")
    public ResponseEntity<String> autenticada() {
        return ResponseEntity.ok("resposta autenticada");
    }

    @GetMapping("/role")
    public ResponseEntity<String> role() {
        return ResponseEntity.ok("resposta role");
    }

    @RequestMapping("/erro")
    public String handleError(HttpServletRequest request, Model model) {
        String erroMensagem;
        StringBuilder stackTrace = new StringBuilder();
        if ((Integer) request.getAttribute("javax.servlet.error.status_code") == 404) {
            erroMensagem = "Página não encontrada";
        }
        else if ((Integer) request.getAttribute("javax.servlet.error.status_code") == 403) {
            erroMensagem = "Página proibida";
        }
        else {
            Exception obj = (Exception) request.getAttribute("org.springframework.boot.web.servlet.error.DefaultErrorAttributes.ERROR");
            erroMensagem = obj.getMessage();
            for (StackTraceElement e : obj.getStackTrace()) {
                stackTrace.append(e.getClassName()).append(".").append(e.getMethodName()).append("(").append(e.getFileName()).append(":").append(e.getLineNumber()).append(")\n");
            }
        }

        model.addAttribute("erroMensagem", erroMensagem);
        model.addAttribute("erroStacktrace", stackTrace);
        return "erro";
    }
}
