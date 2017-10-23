package com.guild.api.demo.controller.advice;

import static com.guild.api.demo.controller.error.ErrorBuilder.buildBadRequestError;
import static com.guild.api.demo.controller.error.ErrorBuilder.buildBasicError;
import static java.lang.String.valueOf;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.util.StringUtils.collectionToCommaDelimitedString;

import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.guild.api.demo.controller.error.Errors;
import com.guild.api.demo.exception.ResourceNotFound;

@ControllerAdvice(annotations = RestController.class)
@Order(Ordered.LOWEST_PRECEDENCE - 1)
public class ErrorHandlingAdvice {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public Errors handleException(ConstraintViolationException e) {
        List<String> errors = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(toList());
        return new Errors(buildBadRequestError(collectionToCommaDelimitedString(errors)));
    }

    @ExceptionHandler(ResourceNotFound.class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public Errors handleException(ResourceNotFound e) {
        return new Errors(buildBasicError(valueOf(NOT_FOUND.value()), "S052", "Resource Not Found", e.getMessage()));
    }
}
