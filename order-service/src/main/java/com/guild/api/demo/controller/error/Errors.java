package com.guild.api.demo.controller.error;

import static java.util.Arrays.asList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Errors")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Errors {
    private final List<Error> errors;

    public Errors(List<Error> errors) {
        this.errors = errors;
    }

    public Errors(Error... errors) {
        this(asList(errors));
    }

    public List<Error> getErrors() {
        return errors;
    }
}
