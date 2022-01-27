package com.example.parserwithweb.exception;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class ExceptionHandlerController {

    private static final Logger LOG = getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(RestException.class)
    public @ResponseBody
    String handleException(RestException e) {
        LOG.error("Ошибка: " + e.getMessage(), e);
        return "Ошибка: " + e.getMessage();
    }
}