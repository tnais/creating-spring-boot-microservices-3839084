package com.example.explorecalijpa.repo;

import com.example.explorecalijpa.model.Difficulty;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.explorecalijpa.model.Tour;

public interface TourRepository extends JpaRepository<Tour, Integer> {
  List<Tour> findByDifficulty(Difficulty diff);
  List<Tour> findByTourPackageCode(String code);
}
