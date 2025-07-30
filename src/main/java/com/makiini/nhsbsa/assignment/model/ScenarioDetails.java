package com.makiini.nhsbsa.assignment.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScenarioDetails {

    private String challenge;
    private String incident;
    private String troubleshooting_step;
}
