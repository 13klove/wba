package web.boostcourse.api.wba.config.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import web.boostcourse.api.wba.config.exception.domain.ErrorMessage;
import web.boostcourse.api.wba.config.exception.domain.ParamValidException;

import java.time.LocalDate;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ResponseStatus(HttpStatus.LOCKED)
    @ExceptionHandler(ParamValidException.class)
    public ErrorMessage handlerConflict(RuntimeException ex){
        return ErrorMessage.builder().code(HttpStatus.LOCKED.value()).message(HttpStatus.LOCKED.getReasonPhrase())
                .timestamp(LocalDate.now()).data(ex.getMessage()).build();
    }

}
