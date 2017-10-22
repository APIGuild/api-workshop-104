package com.guild.api.demo.controller.advice;

import static com.guild.api.demo.controller.error.ErrorBuilder.buildBadRequestError;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
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
}
