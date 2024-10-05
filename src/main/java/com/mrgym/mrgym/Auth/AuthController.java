package com.mrgym.mrgym.Auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
//con lombook se agrgea el constructor con todos los requerimientos
@RequiredArgsConstructor
//los controladores nos permiten exponer nuestros endpoints
public class AuthController {

    private final AuthService authService;

    //responseentityt representeat todos los codigos de respuesta
    //regresa un objeto 
    //ira a buscar al usuario que esta autenticado
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> Login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    //se creara un nuevo registro de usuario
    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse>  Register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }
}
