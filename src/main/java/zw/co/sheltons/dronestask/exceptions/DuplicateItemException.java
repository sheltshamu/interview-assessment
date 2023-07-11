package zw.co.sheltons.dronestask.exceptions;

import java.text.MessageFormat;

public class DuplicateItemException extends RuntimeException{
    public DuplicateItemException(String message, String itemName) {
        super(MessageFormat.format(message,itemName));
    }
}
