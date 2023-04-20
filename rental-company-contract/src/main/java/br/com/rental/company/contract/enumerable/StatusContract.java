package br.com.rental.company.contract.enumerable;

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