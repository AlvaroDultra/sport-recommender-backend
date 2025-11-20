package com.sportrecommender.app.repository;

import com.sportrecommender.app.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {
    
    List<Sport> findByGenderPreference(String gender);
    
    List<Sport> findByGenderPreferenceOrGenderPreference(String gender, String any);
    
    @Query("SELECT s FROM Sport s WHERE " +
           "(s.genderPreference = :gender OR s.genderPreference = 'any') AND " +
           "(s.minHeight IS NULL OR s.minHeight <= :height) AND " +
           "(s.maxHeight IS NULL OR s.maxHeight >= :height)")
    List<Sport> findSportsByGenderAndHeight(@Param("gender") String gender, 
                                            @Param("height") Double height);
}