package zw.co.sheltons.dronestask.exceptions;

import lombok.Getter;
import lombok.ToString;

import java.text.MessageFormat;

@Getter
@ToString
public class BadRequestException extends RuntimeException{
    private int value;

    public BadRequestException(String message) {
        super(message);
    }
    public BadRequestException(String message, int value) {
        super(MessageFormat.format(message,value));
        this.value =value;
    }

}
