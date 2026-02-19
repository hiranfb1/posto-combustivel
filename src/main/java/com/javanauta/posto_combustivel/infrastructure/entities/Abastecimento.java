package com.javanauta.posto_combustivel.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "abastecimento")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Abastecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "bomba_combustivel_id")
    private BombasDeCombustivel bombasDeCombustivel;

    @JoinColumn(name = "data_abastecimento")
    private LocalDate dataAbastecimento;

    @JoinColumn(name = "valor_total")
    private BigDecimal valorTotal;

    @JoinColumn(name = "quantidade_litros")
    private Long quantidadeLitros;
}