package dev.unchk.platformm2po.internal.features.message.domain.exceptions;



public class MessageNotFoundException extends RuntimeException {
    public MessageNotFoundException() {
        super("Message not found");
    }
}
