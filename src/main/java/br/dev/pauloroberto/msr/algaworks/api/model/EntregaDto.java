package br.dev.pauloroberto.msr.algaworks.api.model;

import br.dev.pauloroberto.msr.algaworks.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EntregaDto {
    private Long id;
    private ClienteResumoDto cliente;
    private DestinatarioDto destinatario;
    private BigDecimal taxa;
    private StatusEntrega status;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;
}
