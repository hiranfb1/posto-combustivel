package com.javanauta.posto_combustivel.infrastructure.repositories;

import com.javanauta.posto_combustivel.infrastructure.entities.BombasDeCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BombaDeCombustivelRepository extends JpaRepository<BombasDeCombustivel, Integer> {
}