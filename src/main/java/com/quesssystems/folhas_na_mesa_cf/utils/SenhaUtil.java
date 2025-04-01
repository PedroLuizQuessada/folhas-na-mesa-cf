package com.quesssystems.folhas_na_mesa_cf.utils;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SenhaUtil {

    private final PasswordEncoder passwordEncoder;

    public SenhaUtil(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String criptografar(String senhaDescriptografada) {
        return passwordEncoder.encode(senhaDescriptografada);
    }
}
