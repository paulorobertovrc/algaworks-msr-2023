package br.dev.pauloroberto.msr.algaworks.domain.service;

import br.dev.pauloroberto.msr.algaworks.domain.model.Cliente;
import br.dev.pauloroberto.msr.algaworks.domain.model.Entrega;
import br.dev.pauloroberto.msr.algaworks.domain.model.StatusEntrega;
import br.dev.pauloroberto.msr.algaworks.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class SolicitacaoEntregaService {
    private final EntregaRepository entregaRepository;
    private final CatalogoClienteService catalogoClienteService;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = catalogoClienteService.buscar(
                entrega.getCliente().getId()
        );

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());

        return entregaRepository.save(entrega);
    }
}
