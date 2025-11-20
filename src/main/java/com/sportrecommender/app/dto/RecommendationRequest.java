package com.sportrecommender.app.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationRequest {

    @NotNull(message = "Altura é obrigatória")
    @DecimalMin(value = "0.5", message = "Altura deve ser maior que 0.5m")
    @DecimalMax(value = "3.0", message = "Altura deve ser menor que 3.0m")
    private Double height;

    @NotBlank(message = "Gênero é obrigatório")
    @Pattern(regexp = "^(male|female)$", message = "Gênero deve ser 'male' ou 'female'")
    private String gender;

    @NotEmpty(message = "Escolha pelo menos uma atividade")
    @Size(min = 1, max = 5, message = "Escolha entre 1 e 5 atividades")
    private List<String> activities;
}