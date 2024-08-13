package com.example.UFCHUB.Controllers;

import com.example.UFCHUB.Models.Fighter;
import com.example.UFCHUB.Service.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ufc")
public class UfcController {
    @Autowired
    FighterService fighterService;

    @GetMapping("/fighters/by-name")
    public List<Fighter> getFightersByName(@RequestParam String name) {
        return fighterService.findFightersByName(name);
    }

    @GetMapping("/fighters/by-category")
    public List<Fighter> getFightersByCategory(@RequestParam String category) {
        return fighterService.findFightersByCategory(category);
    }

    @GetMapping("/fighters/by-style")
    public  List<Fighter> getFighterByStyle(@RequestParam String style){
        return fighterService.findByFightingStyle(style);
    }
    @GetMapping("/fighters/by-gym")
    public List<Fighter> getFighterByGym(@RequestParam String gym){

        return fighterService.findByGym(gym);
    }

    @GetMapping("/fighters/by-win")
    public List<Fighter> getFighterByWin(){
        return fighterService.findByWins();
    }

}
