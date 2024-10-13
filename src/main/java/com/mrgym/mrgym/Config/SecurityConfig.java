package com.mrgym.mrgym.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mrgym.mrgym.Jwt.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;
//entonces e usara el amrcado Bean 
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

//seguridad para las rutas 
//cadena de filtros del metood securityfilterchange
//todo los request con auth/seran publicos donde se pueden tener acceso y cualquier otro se pide que se verifique
//desabilitar la proteccion csrf , propia de spring boot 
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    //configuraicon general de toda la secuencia de filtros
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       return http
       
            .csrf(csrf -> csrf.disable())   
            .cors(Customizer.withDefaults())
            .authorizeHttpRequests(authRequest -> 
                authRequest
                    .requestMatchers("/auth/**").permitAll()
                    .anyRequest().authenticated()
                )
                //ahora usaremos una de jwt
                //.formLogin(Customizer.withDefaults())
            .sessionManagement(sessionManager -> 
                sessionManager
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }


}
