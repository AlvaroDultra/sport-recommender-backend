package com.sportrecommender.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationResponse {

    private String sportName; // nome do esporte recomendado

    private String description; // descrição/justificativa

    private Integer matchPercentage; // percentual de compatibilidade (0-100)

    private String message; // mensagem personalizada
}