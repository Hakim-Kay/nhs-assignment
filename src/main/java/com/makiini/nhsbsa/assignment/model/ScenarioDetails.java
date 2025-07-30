package com.makiini.nhsbsa.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScenarioDetails {

    private String challenge;
    private String incident;
    private String troubleshooting_step;
}
