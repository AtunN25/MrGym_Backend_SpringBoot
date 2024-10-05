package com.mrgym.mrgym.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private String telefonoEmpleado;
    private String dniEmpleado;
    private String usuarioEmpleado;
    private String contraseniaEmpleado;
    private Long cargoId; //(relación con CargoEntity)
}
