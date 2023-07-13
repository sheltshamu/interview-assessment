package zw.co.sheltons.dronestask.exceptions;

import lombok.Getter;

import java.text.MessageFormat;

@Getter
public class ItemNotFoundException extends RuntimeException{
    private final Long id;
    public ItemNotFoundException(String message, Long id) {
        super(MessageFormat.format(message,id));
        this.id = id;
    }
}
