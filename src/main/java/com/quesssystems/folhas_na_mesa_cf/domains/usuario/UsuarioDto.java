package com.quesssystems.folhas_na_mesa_cf.domains.usuario;

import com.quesssystems.folhas_na_mesa_cf.interfaces.DtoInterface;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class UsuarioDto implements DtoInterface, Serializable {

    @NotNull
    private String email;

    @NotNull
    private Boolean adm;

    public UsuarioDto(String email, Boolean adm) {
        this.email = email;
        this.adm = adm;
    }
}
