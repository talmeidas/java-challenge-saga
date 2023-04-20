package br.com.saga.orchestration.enumerable;

public enum Status {
    REGULAR("Regular"),
    IRREGULAR("Irregular");

    private final String val;

    private Status(String val) {
        this.val = val;
    }
}