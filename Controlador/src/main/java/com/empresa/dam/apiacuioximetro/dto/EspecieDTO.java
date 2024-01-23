package com.empresa.dam.apiacuioximetro.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EspecieDTO {
    @JsonProperty("nombreEspecie")
    private String nombre;
}
