package br.com.saga.orchestration.enumerable.rental.company;

public enum StatusSupport {
    PENDING("Pendente"),
    ON_GOING("Em Andamento"),
    CONCLUDED("Concluído"),
    CANCELED("Cancelado");

    private final String val;

    private StatusSupport(String val) {
        this.val = val;
    }
}