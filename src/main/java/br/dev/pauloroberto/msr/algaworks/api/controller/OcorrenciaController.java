package br.dev.pauloroberto.msr.algaworks.api.controller;

import br.dev.pauloroberto.msr.algaworks.api.assembler.OcorrenciaAssembler;
import br.dev.pauloroberto.msr.algaworks.api.model.OcorrenciaDto;
import br.dev.pauloroberto.msr.algaworks.domain.model.Entrega;
import br.dev.pauloroberto.msr.algaworks.domain.model.Ocorrencia;
import br.dev.pauloroberto.msr.algaworks.domain.service.BuscaEntregaService;
import br.dev.pauloroberto.msr.algaworks.domain.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
    private final RegistroOcorrenciaService registroOcorrenciaService;
    private final OcorrenciaAssembler ocorrenciaAssembler;
    private final BuscaEntregaService buscaEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaDto registrar(@PathVariable Long entregaId,
                                   @Valid @RequestBody OcorrenciaDto ocorrenciaDto) {
        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId, ocorrenciaDto.getDescricao());
        return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaDto> listar(@PathVariable Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);
        return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
    }
}
