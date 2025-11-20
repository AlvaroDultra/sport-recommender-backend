package com.sportrecommender.app.service;

import com.sportrecommender.app.dto.RecommendationRequest;
import com.sportrecommender.app.dto.RecommendationResponse;
import com.sportrecommender.app.model.Sport;
import com.sportrecommender.app.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationService {
    
    @Autowired
    private SportRepository sportRepository;
    
    public RecommendationResponse recommendSport(RecommendationRequest request) {
        
        // 1. Busca esportes compatíveis com gênero e altura
        List<Sport> candidateSports = sportRepository.findSportsByGenderAndHeight(
            request.getGender(), 
            request.getHeight()
        );
        
        // 2. Calcula pontuação para cada esporte
        Sport bestMatch = candidateSports.stream()
            .map(sport -> {
                int score = calculateMatchScore(sport, request.getActivities());
                sport.setMatchScore(score);
                return sport;
            })
            .filter(sport -> sport.getMatchScore() > 0) // só esportes com algum match
            .max((s1, s2) -> Integer.compare(s1.getMatchScore(), s2.getMatchScore()))
            .orElse(null);
        
        // 3. Monta a resposta
        if (bestMatch != null) {
            int matchPercentage = calculatePercentage(bestMatch.getMatchScore(), request.getActivities().size());
            
            return new RecommendationResponse(
                bestMatch.getName(),
                bestMatch.getDescription(),
                matchPercentage,
                generateMessage(matchPercentage)
            );
        } else {
            return new RecommendationResponse(
                "Nenhum esporte encontrado",
                "Não encontramos um esporte perfeito para seu perfil, mas continue explorando!",
                0,
                "Tente outras combinações de atividades!"
            );
        }
    }
    
    // Calcula quantas atividades do usuário combinam com o esporte
    private int calculateMatchScore(Sport sport, List<String> userActivities) {
        return (int) userActivities.stream()
            .filter(activity -> sport.getMatchingActivities().contains(activity))
            .count();
    }
    
    // Converte score em percentual
    private int calculatePercentage(int score, int totalActivities) {
        return (int) ((score / (double) totalActivities) * 100);
    }
    
    // Gera mensagem baseada no percentual
    private String generateMessage(int percentage) {
        if (percentage >= 80) {
            return "Combinação perfeita! Este esporte é ideal para você! 🎯";
        } else if (percentage >= 50) {
            return "Ótima escolha! Você vai se adaptar bem! 👍";
        } else {
            return "Pode ser uma boa opção para você experimentar! 💪";
        }
    }
}