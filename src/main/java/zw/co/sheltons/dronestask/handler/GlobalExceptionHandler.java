package zw.co.sheltons.dronestask.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import zw.co.sheltons.dronestask.exceptions.DroneNotFoundException;
import zw.co.sheltons.dronestask.exceptions.DuplicateItemException;
import zw.co.sheltons.dronestask.exceptions.BadRequestException;

import java.util.Collections;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public APIResponse<?> invalidRequestException(BadRequestException badRequestException){
        APIResponse<?> apiResponse = new APIResponse<>();
        apiResponse.setStatus("FAILED");
        apiResponse.setErrors(Collections.singletonList(new ErrorDTO("", badRequestException.getMessage())));
        return apiResponse;
    }

    @ExceptionHandler(DuplicateItemException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public APIResponse<?>recordNotFoundException(DuplicateItemException duplicateItemException){
        APIResponse<?> apiResponse = new APIResponse<>();
        apiResponse.setStatus("CONFLICT");
        apiResponse.setErrors(Collections.singletonList(new ErrorDTO("",duplicateItemException.getMessage())));
        return apiResponse;
    }

    @ExceptionHandler(DroneNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public APIResponse<?> droneNotFoundException(DroneNotFoundException droneNotFoundException){
        APIResponse<?> apiResponse = new APIResponse<>();
        apiResponse.setStatus("NOT FOUND");
        apiResponse.setErrors(Collections.singletonList(new ErrorDTO("",droneNotFoundException.getMessage())));
        return apiResponse;
    }

}
