package br.com.saga.orchestration.enumerable.rental.company;

public enum MessageReason {
    PRAISE("Elogio / Sugestão"),
    INFORMATION("Informação"),
    COMPLAINT("Reclamação"),
    REQUEST("Solicitação");

    private final String val;

    private MessageReason(String val) {
        this.val = val;
    }
}