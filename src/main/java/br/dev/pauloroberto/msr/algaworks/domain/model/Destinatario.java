package br.dev.pauloroberto.msr.algaworks.domain.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Data
@Embeddable
public class Destinatario {
    @NotBlank
    @Column(name = "destinatario_nome")
    private String nome;
    @NotBlank
    @Column(name = "destinatario_logradouro")
    private String logradouro;
    @NotBlank
    @Column(name = "destinatario_numero")
    private String numero;
    @Column(name = "destinatario_complemento")
    private String complemento;
    @NotBlank
    @Column(name = "destinatario_bairro")
    private String bairro;
}
