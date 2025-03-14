package com.quesssystems.folhas_na_mesa_cf.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SenhaUtil {

    public String criptografar(String senhaDescriptografada) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(senhaDescriptografada);
    }
}
