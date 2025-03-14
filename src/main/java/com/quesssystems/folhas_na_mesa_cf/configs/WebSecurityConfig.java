package com.quesssystems.folhas_na_mesa_cf.configs;

import com.quesssystems.folhas_na_mesa_cf.enums.RoleEnum;
import com.quesssystems.folhas_na_mesa_cf.repos.UsuarioRepository;
import com.quesssystems.folhas_na_mesa_cf.services.usuario.CustomUsuarioDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UsuarioRepository usuarioRepository;

    public WebSecurityConfig(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(new CustomUsuarioDetailsService(usuarioRepository));
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());

        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/liberada").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/usuarios/criar").permitAll()
                .antMatchers("/usuarios/listarTodos").permitAll()
                .antMatchers("/role").hasRole(RoleEnum.ROLE_ADMIN.getRole())
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .defaultSuccessUrl("/teste", true)
                .permitAll()

                .and()
                .logout()
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                .invalidateHttpSession(true);

        http.sessionManagement()
                .invalidSessionUrl("/login?sessaoexpirada");

        http.csrf().disable();
    }
}
