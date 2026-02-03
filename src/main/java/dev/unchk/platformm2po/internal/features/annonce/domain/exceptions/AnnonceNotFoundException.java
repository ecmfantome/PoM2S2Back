package dev.unchk.platformm2po.internal.features.annonce.domain.exceptions;



public class AnnonceNotFoundException extends RuntimeException {
    public AnnonceNotFoundException() {
        super("Announcement not found");
    }
}
