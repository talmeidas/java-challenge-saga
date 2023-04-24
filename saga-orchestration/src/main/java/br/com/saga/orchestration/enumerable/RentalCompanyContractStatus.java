package br.com.saga.orchestration.enumerable;

public enum RentalCompanyContractStatus {
    PENDING("Pendente"),
    ON_GOING("Em Andamento"),
    CONCLUDED("Concluído"),
    CANCELED("Cancelado");

    private final String val;

    private RentalCompanyContractStatus(String val) {
        this.val = val;
    }
}