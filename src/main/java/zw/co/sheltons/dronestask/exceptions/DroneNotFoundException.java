package zw.co.sheltons.dronestask.exceptions;

import lombok.Getter;

import java.text.MessageFormat;

@Getter
public class DroneNotFoundException extends RuntimeException{
    private final Long id;
    public DroneNotFoundException(String message, Long id) {
        super(MessageFormat.format(message,id));
        this.id = id;
    }
}
