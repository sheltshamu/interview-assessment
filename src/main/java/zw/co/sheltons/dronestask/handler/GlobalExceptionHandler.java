package zw.co.sheltons.dronestask.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import zw.co.sheltons.dronestask.exceptions.DroneNotFoundException;
import zw.co.sheltons.dronestask.exceptions.DuplicateItemException;
import zw.co.sheltons.dronestask.exceptions.InvalidRequestException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public APIResponse<?> invalidRequestException(InvalidRequestException invalidRequestException){
        APIResponse<?> apiResponse = new APIResponse<>();
        apiResponse.setStatus("FAILED");
        return apiResponse;
    }

    @ExceptionHandler(DuplicateItemException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public APIResponse<?>recordNotFoundException(DuplicateItemException duplicateItemException){
        APIResponse<?> apiResponse = new APIResponse<>();
        apiResponse.setStatus("CONFLICT");
        return apiResponse;
    }

    @ExceptionHandler(DroneNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public APIResponse<?> droneNotFoundException(DroneNotFoundException droneNotFoundException){
        APIResponse<?> apiResponse = new APIResponse<>();
        apiResponse.setStatus("NOT FOUND");
        return apiResponse;
    }

}
