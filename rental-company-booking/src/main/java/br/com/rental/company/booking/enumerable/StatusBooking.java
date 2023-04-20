package br.com.rental.company.booking.enumerable;

public enum StatusBooking {
    PENDING("Pendente"),
    ON_GOING("Em Andamento"),
    CONCLUDED("Concluído"),
    CANCELED("Cancelado");

    private final String val;

    private StatusBooking(String val) {
        this.val = val;
    }
}