package com.makiini.nhsbsa.assignment.controller;

import com.makiini.nhsbsa.assignment.model.ScenarioRequest;
import com.makiini.nhsbsa.assignment.model.ScenarioResponse;
import com.makiini.nhsbsa.assignment.service.ScenarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scenario")
public class ScenarioController {

    private final ScenarioService scenarioService;

    public ScenarioController(ScenarioService scenarioService) {
        this.scenarioService = scenarioService;
    }

    @PostMapping
    public ResponseEntity<ScenarioResponse> generateScenario(
        @RequestBody ScenarioRequest request
    ) {
        ScenarioResponse response = scenarioService.generateRandomScenario(
            request
        );
        return ResponseEntity.ok(response);
    }
}
