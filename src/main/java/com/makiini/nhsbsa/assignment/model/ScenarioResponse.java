package com.makiini.nhsbsa.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScenarioResponse {

    private ScenarioRequest inputs;
    private ScenarioDetails scenario;
}
