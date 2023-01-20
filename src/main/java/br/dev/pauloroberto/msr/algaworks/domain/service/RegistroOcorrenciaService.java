package br.dev.pauloroberto.msr.algaworks.domain.service;

import br.dev.pauloroberto.msr.algaworks.domain.model.Entrega;
import br.dev.pauloroberto.msr.algaworks.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class RegistroOcorrenciaService {
    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return entrega.adicionarOcorrencia(descricao);
    }
}
