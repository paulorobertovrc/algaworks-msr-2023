package br.dev.pauloroberto.msr.algaworks.domain.service;

import br.dev.pauloroberto.msr.algaworks.domain.model.Entrega;
import br.dev.pauloroberto.msr.algaworks.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class FinalizacaoEntregaService {
        private final BuscaEntregaService buscaEntregaService;
        private final EntregaRepository entregaRepository;

        @Transactional
        public void finalizar(Long entregaId) {
            Entrega entrega = buscaEntregaService.buscar(entregaId);
            entrega.finalizar();

            entregaRepository.save(entrega);
        }
}
