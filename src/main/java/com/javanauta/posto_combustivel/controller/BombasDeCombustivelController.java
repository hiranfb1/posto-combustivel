package com.javanauta.posto_combustivel.controller;

import com.javanauta.posto_combustivel.controller.dtos.BombasDeCombustivelDTO;
import com.javanauta.posto_combustivel.infrastructure.entities.BombasDeCombustivel;
import com.javanauta.posto_combustivel.service.BombasDeCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bombasDeCombustivel")
@RequiredArgsConstructor
public class BombasDeCombustivelController {
    private final BombasDeCombustivelService bombasDeCombustivelService;

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody BombasDeCombustivelDTO bombasDeCombustivelDTO) {
        bombasDeCombustivelService.criar(bombasDeCombustivelDTO);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<BombasDeCombustivel>> buscarBombasDeCombustivel() {
        return ResponseEntity.ok(bombasDeCombustivelService.buscarBombasDeCombustivel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BombasDeCombustivel> buscarBombaDeCombustivel(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(bombasDeCombustivelService.buscarBombaDeCombustivel(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBombaDeCombustivel(@PathVariable(name = "id") Integer id) {
        bombasDeCombustivelService.deletarBombaDeCombustivel(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> alterarBombaDeCombustivel(@RequestParam(name = "id") Integer id, @RequestBody BombasDeCombustivel bombasDeCombustivel) {
        bombasDeCombustivelService.alterarBombaDeCombustivel(id, bombasDeCombustivel);
        return ResponseEntity.ok().build();
    }
}