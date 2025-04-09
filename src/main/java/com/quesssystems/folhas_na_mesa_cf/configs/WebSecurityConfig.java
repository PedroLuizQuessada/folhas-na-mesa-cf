package com.quesssystems.folhas_na_mesa_cf.configs;

import com.quesssystems.folhas_na_mesa_cf.enums.RoleEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()

                .authorizeHttpRequests((authorize) -> authorize
                        .antMatchers("/liberada").permitAll()
                        .antMatchers("/autenticada").authenticated()
                        .antMatchers("/login").permitAll()
                        .antMatchers("/usuarios/criar").permitAll()
                        .antMatchers("/usuarios/listarTodos").permitAll()
                        .antMatchers("/role").hasRole(RoleEnum.ROLE_ADMIN.getRole()))

                .httpBasic(Customizer.withDefaults())

                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .defaultSuccessUrl("/teste", true)
                .permitAll()

                .and()
                .logout()
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                .invalidateHttpSession(true)

                .and()
                .sessionManagement()
                .invalidSessionUrl("/login?sessaoexpirada");

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.builder()
//                .username("abc")
//                .password(passwordEncoder().encode("999"))
//                .roles("admin")
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}
