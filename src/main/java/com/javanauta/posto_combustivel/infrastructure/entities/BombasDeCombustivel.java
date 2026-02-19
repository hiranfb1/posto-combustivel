package com.javanauta.posto_combustivel.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bombas_de_combustivel")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BombasDeCombustivel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "combustivel_id")
    private TiposDeCombustivel tiposDeCombustivel;
}