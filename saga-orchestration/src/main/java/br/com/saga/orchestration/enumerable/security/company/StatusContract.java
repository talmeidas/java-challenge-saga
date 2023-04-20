package br.com.saga.orchestration.enumerable.security.company;

public enum StatusContract {
    PENDING("Pendente"),
    ON_GOING("Em Andamento"),
    CONCLUDED("Concluído"),
    CANCELED("Cancelado");

    private final String val;

    private StatusContract(String val) {
        this.val = val;
    }
}