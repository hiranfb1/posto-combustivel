package com.javanauta.posto_combustivel.controller;

import com.javanauta.posto_combustivel.infrastructure.entities.Abastecimento;
import com.javanauta.posto_combustivel.service.AbastecimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abastecimento")
@RequiredArgsConstructor
public class AbastecimentoController {
    private final AbastecimentoService abastecimentoService;

    @PostMapping
    public ResponseEntity<Void> abastecer(@RequestParam("idBomba") Integer idBomba, @RequestParam("quantidadeEmLitros") Long litros) {
        abastecimentoService.abastecer(idBomba, litros);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Abastecimento>> buscarAbastecimentos() {
        return ResponseEntity.ok(abastecimentoService.buscarAbastecimentos());
    }
}