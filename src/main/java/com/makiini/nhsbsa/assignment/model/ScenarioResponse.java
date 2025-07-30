package com.makiini.nhsbsa.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScenarioResponse {

    private ScenarioRequest inputs;
    private ScenarioDetails scenario;
}
