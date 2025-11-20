package com.sportrecommender.app.controller;

import com.sportrecommender.app.dto.RecommendationRequest;
import com.sportrecommender.app.dto.RecommendationResponse;
import com.sportrecommender.app.service.RecommendationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommendations")
@CrossOrigin(origins = "*") // permite requisições do frontend
public class RecommendationController {
    
    @Autowired
    private RecommendationService recommendationService;
    
    @PostMapping("/recommend")
    public ResponseEntity<RecommendationResponse> getRecommendation(
            @Valid @RequestBody RecommendationRequest request) {
        
        RecommendationResponse response = recommendationService.recommendSport(request);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("API de Recomendação de Esportes funcionando! ✅");
    }
}