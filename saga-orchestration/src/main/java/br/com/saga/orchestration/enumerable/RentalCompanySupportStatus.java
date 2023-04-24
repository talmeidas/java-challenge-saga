package br.com.saga.orchestration.enumerable;

public enum RentalCompanySupportStatus {
    PENDING("Pendente"),
    ON_GOING("Em Andamento"),
    CONCLUDED("Concluído"),
    CANCELED("Cancelado");

    private final String val;

    private RentalCompanySupportStatus(String val) {
        this.val = val;
    }
}