package controller;

import exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(MovieNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleException(MovieNotFoundException ex) {
        return new ErrorResponse("movie.not.found", ex.getMessage());
    }
    @ExceptionHandler(NoAvailableSeatsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleException(NoAvailableSeatsException ex) {
        return  new ErrorResponse("seats.not.enough", ex.getMessage());
    }
    @ExceptionHandler(ReservationNotEnoughException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleException(ReservationNotEnoughException ex) {
        return  new ErrorResponse("reservation.not.found", ex.getMessage());
    }
    @ExceptionHandler(UserNotActiveException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleException(UserNotActiveException ex) {
        return  new ErrorResponse("user.not.active", ex.getMessage());
    }
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleException( UserNotFoundException ex) {
        return  new ErrorResponse("user.not.found", ex.getMessage());
    }
}
