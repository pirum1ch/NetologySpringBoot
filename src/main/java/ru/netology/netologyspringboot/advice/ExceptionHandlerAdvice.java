package ru.netology.netologyspringboot.advice;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.netologyspringboot.exceptions.InvalidCredentials;
import ru.netology.netologyspringboot.exceptions.UnauthorizedUser;

@Log4j2
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> ice(InvalidCredentials e) {
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> uue(UnauthorizedUser e) {
        log.log(Level.ERROR, e.getLocalizedMessage());
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.UNAUTHORIZED);
    }

}
