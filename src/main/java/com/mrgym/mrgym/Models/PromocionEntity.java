package com.mrgym.mrgym.Models;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "promociones")
public class PromocionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_promocion;

    @NotBlank
    @Size(max = 30)
    private String nombre_promocion;

    @NotBlank
    @Min(1)
    @Size(max = 30)
    private int duracion_meses;

    @NotBlank
    @Size(max = 255)
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = MembresiaEntity.class,fetch = FetchType.LAZY,mappedBy = "promocionEntities")
    private List<MembresiaEntity> membresiaEntities;
}
