package br.com.saga.orchestration.enumerable;

public enum SecurityCompanyContractStatus {
    PENDING("Pendente"),
    ON_GOING("Em Andamento"),
    CONCLUDED("Concluído"),
    CANCELED("Cancelado");

    private final String val;

    private SecurityCompanyContractStatus(String val) {
        this.val = val;
    }
}