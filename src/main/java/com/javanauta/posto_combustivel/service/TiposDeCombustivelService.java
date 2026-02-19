package com.javanauta.posto_combustivel.service;

import com.javanauta.posto_combustivel.controller.dtos.TiposDeCombustivelDTO;
import com.javanauta.posto_combustivel.infrastructure.entities.TiposDeCombustivel;
import com.javanauta.posto_combustivel.infrastructure.repositories.TipoDeCombustivelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TiposDeCombustivelService {
    private final TipoDeCombustivelRepository tipoDeCombustivelRepository;

    public void criar(TiposDeCombustivelDTO tiposDeCombustivelDTO) {
        TiposDeCombustivel newTiposDeCombustivel = new TiposDeCombustivel();
        newTiposDeCombustivel.setNome(tiposDeCombustivelDTO.nome());
        newTiposDeCombustivel.setPrecoPorLitro(tiposDeCombustivelDTO.precoPorLitro());
        tipoDeCombustivelRepository.save(newTiposDeCombustivel);
    }

    public List<TiposDeCombustivel> buscarTiposDeCombustivel() {
        return tipoDeCombustivelRepository.findAll();
    }

    public TiposDeCombustivel buscarTipoDeCombustivel(Integer id) {
        return tipoDeCombustivelRepository.findById(id).orElseThrow(() -> new NullPointerException("Tipo de combustível não encontrado pelo id: " + id));
    }

    public void alterarTipoDeCombustivel(Integer id, TiposDeCombustivel tiposDeCombustivel) {
        TiposDeCombustivel tipo = buscarTipoDeCombustivel(id);
        tiposDeCombustivel.setId(tipo.getId());
        tipoDeCombustivelRepository.save(tiposDeCombustivel);
    }

    @Transactional
    public void deletarTipoDeCombustivel(Integer id) {
        tipoDeCombustivelRepository.deleteById(id);
    }
}