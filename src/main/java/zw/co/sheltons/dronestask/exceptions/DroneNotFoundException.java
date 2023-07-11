package zw.co.sheltons.dronestask.exceptions;

import java.text.MessageFormat;

public class DroneNotFoundException extends RuntimeException{
    public DroneNotFoundException(String message, Long id) {
        super(MessageFormat.format(message,id));
    }
}
