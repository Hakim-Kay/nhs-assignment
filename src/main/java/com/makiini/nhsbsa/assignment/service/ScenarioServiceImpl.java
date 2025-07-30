package com.makiini.nhsbsa.assignment.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.makiini.nhsbsa.assignment.model.ScenarioDetails;
import com.makiini.nhsbsa.assignment.model.ScenarioRequest;
import com.makiini.nhsbsa.assignment.model.ScenarioResponse;
import java.io.InputStream;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class ScenarioServiceImpl implements ScenarioService {

    private final List<ScenarioResponse> scenarios;
    private final Random random = new Random();

    public ScenarioServiceImpl() {
        this.scenarios = loadScenariosFromFile();
    }

    @Override
    public ScenarioResponse generateRandomScenario(ScenarioRequest request) {
        ScenarioResponse randomTemplate = scenarios.get(
            random.nextInt(scenarios.size())
        );
        ScenarioDetails chosenDetails = randomTemplate.getScenario();
        return new ScenarioResponse(request, chosenDetails);
    }

    // This private method handles the details of loading the file.
    private List<ScenarioResponse> loadScenariosFromFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = TypeReference.class.getResourceAsStream(
                "/scenarios.json"
            );
            return objectMapper.readValue(
                inputStream,
                new TypeReference<>() {}
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(
                "Failed to load scenarios from JSON file",
                e
            );
        }
    }
}
