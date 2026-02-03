package dev.unchk.platformm2po.internal.features.devoir_rendu.domain.exceptions;



public class DevoirRenduNotFoundException extends RuntimeException {
    public DevoirRenduNotFoundException() {
        super("Duty rendered not found");
    }
}
