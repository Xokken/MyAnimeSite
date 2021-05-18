package ru.itis.xokken.myanimesity.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

@Slf4j
@ControllerAdvice
@Data
public class MyExceptionHandler {

    @ExceptionHandler(value = FileNotFoundException.class)
    public String handleConflict(FileNotFoundException ex) {
        log.error("OH NO IT IS A TRAP!!!", ex);
        return "myerror";
    }







}
