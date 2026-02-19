package com.javanauta.posto_combustivel.service;

import com.javanauta.posto_combustivel.infrastructure.entities.Abastecimento;
import com.javanauta.posto_combustivel.infrastructure.entities.BombasDeCombustivel;
import com.javanauta.posto_combustivel.infrastructure.repositories.AbastecimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AbastecimentoService {
    private final AbastecimentoRepository abastecimentoRepository;
    private final BombasDeCombustivelService bombasDeCombustivelService;

    public void abastecer(Integer idBomba, Long litros) {
        BombasDeCombustivel bomba = bombasDeCombustivelService.buscarBombaDeCombustivel(idBomba);
        BigDecimal valorTotal = bomba.getTiposDeCombustivel().getPrecoPorLitro().multiply(BigDecimal.valueOf(litros));
        Abastecimento abastecimento = Abastecimento.builder()
                .bombasDeCombustivel(bomba)
                .dataAbastecimento(LocalDate.now())
                .valorTotal(valorTotal)
                .quantidadeLitros(litros)
                .build();
        abastecimentoRepository.save(abastecimento);
    }

    public List<Abastecimento> buscarAbastecimentos() {
        return abastecimentoRepository.findAll();
    }
}