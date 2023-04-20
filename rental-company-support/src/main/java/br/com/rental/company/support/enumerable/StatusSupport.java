package br.com.rental.company.support.enumerable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Arrays;

public enum StatusSupport {
    PENDING("Pendente"),
    ON_GOING("Em Andamento"),
    CONCLUDED("Concluído"),
    CANCELED("Cancelado");

    private final String val;

    private StatusSupport(String val) {
        this.val = val;
    }
}