package com.makiini.nhsbsa.assignment.service;

import com.makiini.nhsbsa.assignment.model.ScenarioDetails;
import com.makiini.nhsbsa.assignment.model.ScenarioRequest;
import com.makiini.nhsbsa.assignment.model.ScenarioResponse;
import org.springframework.stereotype.Service;

@Service
public class ScenarioServiceImpl implements ScenarioService {

    @Override
    public ScenarioResponse generateRandomScenario(ScenarioRequest request) {
        ScenarioDetails dummyDetails = ScenarioDetails.builder()
            .challenge("placeholder Challenge")
            .incident("placeholder Incident")
            .troubleshooting_step("placeholder Step")
            .build();

        return new ScenarioResponse(request, dummyDetails);
    }
}
