package br.com.saga.orchestration.enumerable;

public enum RentalCompanySupportMessageReason {
    PRAISE("Elogio / Sugestão"),
    INFORMATION("Informação"),
    COMPLAINT("Reclamação"),
    REQUEST("Solicitação");

    private final String val;

    private RentalCompanySupportMessageReason(String val) {
        this.val = val;
    }
}