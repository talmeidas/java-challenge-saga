package br.com.saga.orchestration.enumerable;

public enum DetranDriverLicenseStatus {
    REGULAR("Regular"),
    IRREGULAR("Irregular");

    private final String val;

    private DetranDriverLicenseStatus(String val) {
        this.val = val;
    }
}