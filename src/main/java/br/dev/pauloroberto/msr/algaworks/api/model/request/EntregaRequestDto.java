package br.dev.pauloroberto.msr.algaworks.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class EntregaRequestDto {

        @Valid
        @NotNull
        private ClienteIdRequest cliente;
        @Valid
        @NotNull
        private DestinatarioRequest destinatario;
        @NotNull
        private BigDecimal taxa;
}
