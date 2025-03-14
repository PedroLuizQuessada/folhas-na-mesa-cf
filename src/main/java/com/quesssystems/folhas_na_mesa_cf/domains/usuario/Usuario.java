package com.quesssystems.folhas_na_mesa_cf.domains.usuario;

import javax.persistence.*;

import com.quesssystems.folhas_na_mesa_cf.interfaces.EntityInterface;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class Usuario implements EntityInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 64)
    private String senha;

    @Column(nullable = false)
    private boolean adm;

    @Override
    public UsuarioDto entityToDto() {
        return new UsuarioDto(this.email, this.isAdm());
    }
}
