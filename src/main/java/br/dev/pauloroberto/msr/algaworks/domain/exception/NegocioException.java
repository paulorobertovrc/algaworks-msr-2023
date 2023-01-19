package br.dev.pauloroberto.msr.algaworks.domain.exception;

public class NegocioException extends RuntimeException {
    public NegocioException(String message) {
        super(message);
    }
}
