package com.javanauta.posto_combustivel.controller;

import com.javanauta.posto_combustivel.controller.dtos.TiposDeCombustivelDTO;
import com.javanauta.posto_combustivel.infrastructure.entities.TiposDeCombustivel;
import com.javanauta.posto_combustivel.service.TiposDeCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiposDeCombustivel")
@RequiredArgsConstructor
public class TiposDeCombustivelController {
    private final TiposDeCombustivelService tiposDeCombustivelService;

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody TiposDeCombustivelDTO tiposDeCombustivelDTO) {
        tiposDeCombustivelService.criar(tiposDeCombustivelDTO);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<TiposDeCombustivel>> buscarTiposDeCombustivel() {
        return ResponseEntity.ok(tiposDeCombustivelService.buscarTiposDeCombustivel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TiposDeCombustivel> buscarTipoDeCombustivel(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(tiposDeCombustivelService.buscarTipoDeCombustivel(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTipoDeCombustivel(@PathVariable(name = "id") Integer id) {
        tiposDeCombustivelService.deletarTipoDeCombustivel(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> alterarTipoDeCombustivel(@RequestParam(name = "id") Integer id, @RequestBody TiposDeCombustivel tiposDeCombustivel) {
        tiposDeCombustivelService.alterarTipoDeCombustivel(id, tiposDeCombustivel);
        return ResponseEntity.ok().build();
    }
}