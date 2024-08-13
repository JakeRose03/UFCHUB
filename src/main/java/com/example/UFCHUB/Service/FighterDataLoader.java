package com.example.UFCHUB.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;
import com.example.UFCHUB.fighterDTO.FighterDTO;

@Service
public class FighterDataLoader {

    @Autowired
    private FighterService fighterService;

    private final RestTemplate restTemplate = new RestTemplate();

    public void loadFighters() {
        String apiUrl = "https://api.octagon-api.com/fighters"; // Replace with actual API URL
        ResponseEntity<Map<String, FighterDTO>> response =
                restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<Map<String, FighterDTO>>() {});

        Map<String, FighterDTO> fighters = response.getBody();

        if (fighters != null) {
            fighters.forEach((key, fighterDTO) -> {
                fighterService.saveFighter(fighterDTO);
            });
        }
    }
        aert
}
