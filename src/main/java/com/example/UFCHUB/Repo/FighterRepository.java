package com.example.UFCHUB.Repo;

import com.example.UFCHUB.Models.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FighterRepository extends JpaRepository<Fighter, String> {

    // Find fighters whose names contain the provided substring, ignoring case
    List<Fighter> findByNameContainingIgnoreCase(String name);

    // Find fighters by weight class (case insensitive)
    List<Fighter> findByCategoryContainingIgnoreCase(String category);

    // Method to find fighters by fighting style, case insensitive
    List<Fighter> findByFightingStyleContainingIgnoreCase(String fightingStyle);

    List<Fighter> findByTrainsAtContainingIgnoreCase(String gym);

    List<Fighter> findAllByOrderByWinsDesc();

}
