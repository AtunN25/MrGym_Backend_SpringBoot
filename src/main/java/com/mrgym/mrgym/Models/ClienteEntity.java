package com.mrgym.mrgym.Models;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    @NotBlank
    @Size(max = 30)
    private String nombre_cliente;

    @NotBlank
    @Size(max = 30)
    private String apellido_cliente;

    @Size(min = 9, max = 15) 
    @NotBlank
    private String telefono_cliente;

    //por a o b motivos tiene otra nacionalidad
    @NotNull
    @NotBlank
    @Column(unique = true, nullable = false)
    @Size(min = 8, max = 12) 
    private String dni_cliente;

    @Email
    @Size(max = 30)
    private String email;

    //se aplicara en un futuro para ventas
    private Boolean miembro;
    //estado del cliente 
    private Boolean habilitado;

    //casada sirve para eliminar , si es necesario
    //mappedBy  se deifni como conecta cliente con membresia , por ense se conecta por el objeto clienteEntites,util para el Join
    //targetEntity ayuda a especificar a que Entidad se refiere aunque esta pueda inferirla a partir del TIpo de dato
    //es una lista de membresia que tiene 
    @OneToMany(cascade = CascadeType.ALL,targetEntity = MembresiaEntity.class,fetch = FetchType.LAZY,mappedBy = "clienteEntities")
    @JsonIgnore
    private List<MembresiaEntity> membresiaEntities;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = AsistenciaEntity.class,fetch = FetchType.LAZY,mappedBy = "clienteEntities")
    @JsonIgnore
    private List<AsistenciaEntity> asistenciaEntities;
}
