package zw.co.sheltons.dronestask.exceptions;

import lombok.Getter;

import java.text.MessageFormat;

@Getter
public class DuplicateItemException extends RuntimeException{
    private String itemName;
    public DuplicateItemException(String message, String itemName) {
        super(MessageFormat.format(message,itemName));
        this.itemName = itemName;
    }
}
