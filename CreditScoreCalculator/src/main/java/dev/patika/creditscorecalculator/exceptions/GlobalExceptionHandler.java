package dev.patika.creditscorecalculator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({CustomerAlreadyExists.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CreditScoreAppErrorMessage> handleException(CustomerAlreadyExists exc){
        CreditScoreAppErrorMessage response = prepareErrorResponse(HttpStatus.BAD_REQUEST, exc.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CustomerNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CreditScoreAppErrorMessage> handleException(CustomerNotFoundException exc){
        CreditScoreAppErrorMessage response = prepareErrorResponse(HttpStatus.BAD_REQUEST, exc.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({IllegalSSIDNumberException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CreditScoreAppErrorMessage> handleException(IllegalSSIDNumberException exc){
        CreditScoreAppErrorMessage response = prepareErrorResponse(HttpStatus.BAD_REQUEST, exc.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private CreditScoreAppErrorMessage prepareErrorResponse(HttpStatus httpStatus, String message) {
        CreditScoreAppErrorMessage response = new CreditScoreAppErrorMessage();
        response.setStatus(httpStatus.value());
        response.setMessage(message);
        response.setTimestamp(System.currentTimeMillis());
        return response;
    }
}
