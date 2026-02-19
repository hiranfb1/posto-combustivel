package com.javanauta.posto_combustivel.service;

import com.javanauta.posto_combustivel.controller.dtos.BombasDeCombustivelDTO;
import com.javanauta.posto_combustivel.infrastructure.entities.BombasDeCombustivel;
import com.javanauta.posto_combustivel.infrastructure.repositories.BombaDeCombustivelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BombasDeCombustivelService {
    private final BombaDeCombustivelRepository bombaDeCombustivelRepository;

    public void criar(BombasDeCombustivelDTO bombasDeCombustivelDTO) {
        BombasDeCombustivel newBombasDeCombustivel = new BombasDeCombustivel();
        newBombasDeCombustivel.setNome(bombasDeCombustivelDTO.nome());
        newBombasDeCombustivel.setTiposDeCombustivel(bombasDeCombustivelDTO.tiposDeCombustivel());
        bombaDeCombustivelRepository.save(newBombasDeCombustivel);
    }

    public List<BombasDeCombustivel> buscarBombasDeCombustivel() {
        return bombaDeCombustivelRepository.findAll();
    }

    public BombasDeCombustivel buscarBombaDeCombustivel(Integer id) {
        return bombaDeCombustivelRepository.findById(id).orElseThrow(() -> new NullPointerException("Bomba de combustível não encontrada pelo id: " + id));
    }

    public void alterarBombaDeCombustivel(Integer id, BombasDeCombustivel bombasDeCombustivel) {
        BombasDeCombustivel bomba = buscarBombaDeCombustivel(id);
        bombasDeCombustivel.setId(bomba.getId());
        bombaDeCombustivelRepository.save(bombasDeCombustivel);
    }

    @Transactional
    public void deletarBombaDeCombustivel(Integer id) {
        bombaDeCombustivelRepository.deleteById(id);
    }
}