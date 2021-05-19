package ru.itis.xokken.myanimesity.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.FileNotFoundException;

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
