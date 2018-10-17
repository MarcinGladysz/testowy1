package testowy1.kafka;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import testowy1.exceptions.ResourceNotFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {


    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody
    String handleResourceNotFound(final ResourceNotFoundException ex, final HttpServletRequest request) {

        return "test wyjatku poszedl ok";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody String handleOtherException(final Exception ex){
        ex.printStackTrace();

        return "i w p**** wyladowal i caly misterny plan tez w p**** \\/n"+ ex.getMessage();
    }
}
