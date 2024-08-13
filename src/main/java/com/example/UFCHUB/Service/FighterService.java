package com.example.UFCHUB.Service;

import com.example.UFCHUB.Models.Fighter;
import com.example.UFCHUB.Repo.FighterRepository;
import com.example.UFCHUB.fighterDTO.FighterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FighterService {

    @Autowired
    FighterRepository fighterRepository;

    public List<Fighter> findFightersByName(String name) {
        return fighterRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Fighter> findFightersByCategory(String category) {
        return fighterRepository.findByCategoryContainingIgnoreCase(category);
    }

    public List<Fighter> findByFightingStyle(String style){
        return fighterRepository.findByFightingStyleContainingIgnoreCase(style);
    }

    public List<Fighter> findByGym(String gym){
        return fighterRepository.findByTrainsAtContainingIgnoreCase(gym);
    }

    public List<Fighter> findByWins(){
        return fighterRepository.findAllByOrderByWinsDesc();
    }

    public void saveFighter(FighterDTO fighterDTO) {
        Fighter fighter = new Fighter();
        fighter.setName(fighterDTO.getName());
        fighter.setCategory(fighterDTO.getCategory());
        fighter.setDraws(fighterDTO.getDraws()); // Keep as String
        fighter.setImgUrl(fighterDTO.getImgUrl());
        fighter.setLosses(fighterDTO.getLosses()); // Keep as String
        fighter.setStatus(fighterDTO.getStatus());
        fighter.setPlaceOfBirth(fighterDTO.getPlaceOfBirth());
        fighter.setTrainsAt(fighterDTO.getTrainsAt());
        fighter.setFightingStyle(fighterDTO.getFightingStyle());
        fighter.setAge(fighterDTO.getAge()); // Keep as String
        fighter.setHeight(fighterDTO.getHeight()); // Keep as String
        fighter.setWeight(fighterDTO.getWeight()); // Keep as String
        fighter.setOctagonDebut(fighterDTO.getOctagonDebut()); // Keep as String
        fighter.setReach(fighterDTO.getReach()); // Keep as String
        fighter.setLegReach(fighterDTO.getLegReach()); // Keep as String
        String winsAsString = fighterDTO.getWins() != null ? fighterDTO.getWins().toString() : "0";
        try {
            fighter.setWins(Integer.parseInt(winsAsString));
        } catch (NumberFormatException e) {
            fighter.setWins(0); // Default to 0 if the conversion fails
        }

        System.out.println("Processing fighter: " + fighterDTO.getName() + " with wins: " + fighter.getWins());

        fighterRepository.save(fighter);
    }

}
