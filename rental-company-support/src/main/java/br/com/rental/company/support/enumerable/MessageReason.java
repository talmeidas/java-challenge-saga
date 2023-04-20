package br.com.rental.company.support.enumerable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

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