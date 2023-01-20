package br.dev.pauloroberto.msr.algaworks.domain.service;

import br.dev.pauloroberto.msr.algaworks.domain.exception.EntidadeNaoEncontradaException;
import br.dev.pauloroberto.msr.algaworks.domain.model.Entrega;
import br.dev.pauloroberto.msr.algaworks.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuscaEntregaService {
    private final EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId) {
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
    }
}
