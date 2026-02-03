package dev.unchk.platformm2po.internal.features.devoir.domain.exceptions;



public class DevoirNotFoundException extends RuntimeException {
    public DevoirNotFoundException() {
        super("Duty not found");
    }
}
