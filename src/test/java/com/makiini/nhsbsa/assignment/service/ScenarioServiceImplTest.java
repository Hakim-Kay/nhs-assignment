package com.makiini.nhsbsa.assignment.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.makiini.nhsbsa.assignment.model.ScenarioRequest;
import com.makiini.nhsbsa.assignment.model.ScenarioResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScenarioServiceImplTest {

    private ScenarioServiceImpl scenarioService;

    @BeforeEach
    void setUp() {
        scenarioService = new ScenarioServiceImpl();
    }

    @Test
    void generateRandomScenario_shouldReturnScenarioFromFile() {
        ScenarioRequest request = new ScenarioRequest();
        request.setTechnology("DevOps");
        request.setRole("System Administrator");
        request.setEnvironment("Cloud Infrastructure");

        ScenarioResponse response = scenarioService.generateRandomScenario(
            request
        );

        assertThat(response).isNotNull();
        assertThat(response.getInputs()).isEqualTo(request);
        assertThat(response.getScenario()).isNotNull();
        assertThat(response.getScenario().getChallenge())
            .isNotNull()
            .isNotEqualTo("placeholder Challenge");
    }
}
