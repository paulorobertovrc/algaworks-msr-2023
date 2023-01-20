package br.dev.pauloroberto.msr.algaworks.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OcorrenciaRequest {
    @NotBlank
    private String descricao;
}
