package com.sportrecommender.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "sports")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // ex: "Basquete", "Xadrez"

    @Column(length = 1000)
    private String description; // descrição do esporte

    private Double minHeight; // altura mínima recomendada (opcional)

    private Double maxHeight; // altura máxima recomendada (opcional)

    @Column(length = 20)
    private String genderPreference; // "male", "female", "any"

    @ElementCollection
    @CollectionTable(name = "sport_activities", joinColumns = @JoinColumn(name = "sport_id"))
    @Column(name = "activity_name")
    private List<String> matchingActivities; // atividades que combinam com esse esporte

    private Integer matchScore; // pontuação de match (usado internamente)
}