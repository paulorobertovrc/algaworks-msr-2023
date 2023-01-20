package br.dev.pauloroberto.msr.algaworks.api.controller;

import br.dev.pauloroberto.msr.algaworks.api.assembler.EntregaAssembler;
import br.dev.pauloroberto.msr.algaworks.api.model.EntregaDto;
import br.dev.pauloroberto.msr.algaworks.api.model.request.EntregaRequestDto;
import br.dev.pauloroberto.msr.algaworks.domain.model.Entrega;
import br.dev.pauloroberto.msr.algaworks.domain.repository.EntregaRepository;
import br.dev.pauloroberto.msr.algaworks.domain.service.FinalizacaoEntregaService;
import br.dev.pauloroberto.msr.algaworks.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
    private final SolicitacaoEntregaService solicitacaoEntregaService;
    private final FinalizacaoEntregaService finalizacaoEntregaService;
    private final EntregaRepository entregaRepository;
    private final EntregaAssembler entregaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaDto solicitar(@Valid @RequestBody EntregaRequestDto entregaRequestDto) {
        Entrega novaEntrega = entregaAssembler.toEntity(entregaRequestDto);
        Entrega entregaSolitada = solicitacaoEntregaService.solicitar(novaEntrega);

        return entregaAssembler.toModel(entregaSolitada);
    }

    @GetMapping
    public List<EntregaDto> listar() {
        return entregaAssembler.toCollectionModel(entregaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaDto> buscar(@PathVariable Long id) {
        return entregaRepository.findById(id)
                .map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long id) {
        finalizacaoEntregaService.finalizar(id);
    }
}
