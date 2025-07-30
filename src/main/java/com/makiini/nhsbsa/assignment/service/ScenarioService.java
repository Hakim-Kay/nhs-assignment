package com.makiini.nhsbsa.assignment.service;

import com.makiini.nhsbsa.assignment.model.ScenarioRequest;
import com.makiini.nhsbsa.assignment.model.ScenarioResponse;

public interface ScenarioService {
    ScenarioResponse generateRandomScenario(ScenarioRequest request);
}
