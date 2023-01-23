package kr.gyuna.interview.common.exception;

import kr.gyuna.interview.common.response.DefaultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest webRequest){
        DefaultResponse defaultResponse =
                new DefaultResponse(
                        409,
                        exception.getMessage(),
                        null
                );

        return new ResponseEntity<>(
                defaultResponse,
                HttpStatus.OK
        );
    }

}