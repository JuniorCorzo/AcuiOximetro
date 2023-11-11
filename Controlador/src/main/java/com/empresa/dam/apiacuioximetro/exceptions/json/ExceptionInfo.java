package com.empresa.dam.apiacuioximetro.exceptions.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ExceptionInfo {
    @JsonProperty("message")
    private String message;
    @JsonProperty("status-code")
    private HttpStatus status;
}

