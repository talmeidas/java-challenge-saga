package br.com.rental.company.support.enumerable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Arrays;

public enum Country {
    BRASIL("Brasil");

    private final String val;

    private Country(String val) {
        this.val = val;
    }
}