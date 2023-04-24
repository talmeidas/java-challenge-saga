package br.com.saga.orchestration.enumerable;

public enum RentalCompanyBookingStatus {
    PENDING("Pendente"),
    ON_GOING("Em Andamento"),
    CONCLUDED("Concluído"),
    CANCELED("Cancelado");

    private final String val;

    private RentalCompanyBookingStatus(String val) {
        this.val = val;
    }
}