package com.mrgym.mrgym.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrgym.mrgym.Jwt.JwtService;
import com.mrgym.mrgym.Models.CargoEntity;
import com.mrgym.mrgym.Models.EmpleadoEntity;
import com.mrgym.mrgym.Repositories.CargoRepo;
import com.mrgym.mrgym.Repositories.EmpleadoRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    

    //@Autowired
    private final CargoRepo cargoRepo;
    private final EmpleadoRepo empleadoRepo;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public AuthResponse login(LoginRequest request) {
        //aca recibe el username y el password
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        //luego generamos el token
        UserDetails empleado = empleadoRepo.findByUsuarioEmpleado(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(empleado);
        return AuthResponse.builder()
            .token(token)
            .build();
    }

    //esto sera por metodos sin interfaz , por el momento
    public AuthResponse register(RegisterRequest request) {

        CargoEntity cargo = cargoRepo.findById(request.getCargoId())
                .orElseThrow(() -> new IllegalArgumentException("cargo no encontrado"));

        //patron de disenio builder
        EmpleadoEntity empleado = EmpleadoEntity.builder()
                .nombre_empleado(request.getNombreEmpleado())
                .apellido_empleado(request.getApellidoEmpleado())
                .telefono_empleado(request.getTelefonoEmpleado())
                .dni_empleado(request.getDniEmpleado())
                .usuario_empleado(request.getUsuarioEmpleado())
                .contrasenia_empleado(passwordEncoder.encode(request.getContraseniaEmpleado())) // Asegúrate de encriptar la contraseña
                .cargoEntity(cargo) // Asignar el cargo
                .build();
        
        empleadoRepo.save(empleado);

        return AuthResponse.builder()
            .token(jwtService.getToken(empleado))
            .build();
        
    }

}
